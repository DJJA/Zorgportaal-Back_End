package dao.user;

import dao.GenericDAO;
import domain.Mentor;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MentorDAOJPAImpl extends GenericDAO implements MentorDAO {

    public MentorDAOJPAImpl(EntityManager em) {
        super(em);
    }

    public Iterable<Mentor> getAll() {
        Iterable<Mentor> mentors = null;

        Query q = em.createQuery("select m from Mentor as m");
        try {
            mentors = q.getResultList();
        } catch (Exception ex) {

        }

        return mentors;
    }

    public Mentor getById(Long id) {
        Mentor mentor = null;

        Query q = em.createQuery("select m from Mentor as m where m.id = :id");
        q.setParameter("id", id);
        try {
            mentor = (Mentor) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return mentor;
    }

    public Mentor add(Mentor value) {
        em.persist(value);
        return null;
    }

    public Mentor update(Mentor value) {
        return em.merge(value);
    }

    @Override
    public void addClientToMentor(Long mentorId, Long clientId) {
        Query q = em.createNativeQuery("insert into Mentor_Client(MentorId, ClientId) values(:mentorId, :clientId)");   // TODO: might not be database abstract; this query might not work for every database
//        Query q = em.createQuery("insert into Mentor_Client(MentorId, ClientId) values(:mentorId, :clientId)");
        q.setParameter("mentorId", mentorId);
        q.setParameter("clientId", clientId);
        q.executeUpdate();
    }

    @Override
    public void removeClientFromMentor(Long mentorId, Long clientId) {
        Query q = em.createNativeQuery("delete from Mentor_Client where MentorId = :mentorId and ClientId = :clientId");
        q.setParameter("mentorId", mentorId);
        q.setParameter("clientId", clientId);
        q.executeUpdate();
    }
}
