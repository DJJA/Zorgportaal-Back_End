package dao.user;

import dao.GenericDAO;
import domain.Mentor;

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
}
