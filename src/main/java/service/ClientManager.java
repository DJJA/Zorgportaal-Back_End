package service;

import dao.user.ClientDAO;
import dao.user.ClientDAOImpl;
import domain.Client;
import factory.HibernateFactory;

import javax.persistence.EntityManager;

public class ClientManager {

    public void addClient(Client client) {
        EntityManager em = HibernateFactory.getEntityManager();
        ClientDAO clientDAO = new ClientDAOImpl(em);

        em.getTransaction().begin();

        if(client.getAccount() != null)
            client.setAccount(em.merge(client.getAccount()));

        clientDAO.add(client);

        em.getTransaction().commit();
        em.close();
    }
}
