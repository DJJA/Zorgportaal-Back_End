package dao.user;

import domain.Client;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ClientDAOImpl implements ClientDAO {
    private EntityManager em;

    public ClientDAOImpl(EntityManager em) {
        this.em = em;
    }

    public Collection<Client> getAll() {
        return null;
    }

    public Client add(Client value) {
        em.persist(value);
        return null;
    }

    public Client update(Client value) {
        return null;
    }
}
