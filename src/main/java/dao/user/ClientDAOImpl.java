package dao.user;

import dao.GenericDAO;
import domain.Client;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClientDAOImpl extends GenericDAO implements ClientDAO {

    public ClientDAOImpl(EntityManager em) {
        super(em);
    }

    public Iterable<Client> getAll() {
        Iterable<Client> clients = null;

        Query q = em.createQuery("select c from Client as c");
        try {
            clients = q.getResultList();
        } catch (Exception ex) {

        }

        return clients;
    }

    public Client add(Client value) {
        em.persist(value);
        return null;
    }

    public Client update(Client value) {
        return em.merge(value);
    }

    public Client getById(Long clientId) {
        Client client = null;

        Query q = em.createQuery("select c from Client as c where c.id = :id");
        q.setParameter("id", clientId);
        try {
            client = (Client) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return client;
    }

    public void close() {
        System.out.println("jaaaa gesloten!");
    }

    @Override
    public Iterable<Client> getClientsByMentorId(Long mentorId) {
        Iterable<Client> clients = null;

        Query q = em.createQuery("select c from Client as c inner join c.mentors as m where m.id = :mentorId");
//        Query q = em.createNativeQuery("select u.Id, u.Birthday from Client as c inner join Mentor_Client as mc on c.UserId = mc.ClientId inner join User as u on c.UserId = u.Id where mc.MentorId = :mentorId");
        q.setParameter("mentorId", mentorId);
        try {
            clients = q.getResultList();
        } catch (Exception ex) {

        }

        return clients;
    }
}
