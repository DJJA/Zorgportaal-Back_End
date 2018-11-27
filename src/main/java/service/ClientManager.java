package service;

import authentication.Account;
import authentication.Role;
import authentication.Scope;
import dao.user.ClientDAO;
import dao.user.ClientDAOImpl;
import domain.Client;
import factory.DAOFactory;
import factory.HibernateFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientManager {

    public void addClient(Client client) {
//        EntityManager em = HibernateFactory.getEntityManager();
//        ClientDAO clientDAO = new ClientDAOImpl(em);

        ClientDAO clientDAO = DAOFactory.getClientDAO();
        EntityManager em = clientDAO.getEntityMangaer();

        em.getTransaction().begin();

        if(client.getAccount() != null) {
//            Account account = client.getAccount();
//            if(account.getRoles() != null) {
//                List<Role> roles = account.getRoles();
//                for (Role role : roles) {
//                    if (role.getScopes() != null) {
//                        List<Scope> scopes = role.getScopes();
//                        for (Scope scope : scopes) {
//                            scope = em.merge(scope);
//                        }
//                    }
//                    role = em.merge(role);
//                }
//            }
            client.setAccount(em.merge(client.getAccount()));
        }

        clientDAO.add(client);

        em.getTransaction().commit();
        em.close();
    }

    public void updateClient(Client client) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        EntityManager em = clientDAO.getEntityMangaer();

        em.getTransaction().begin();

        if(client.getAccount() != null)
            client.setAccount(em.merge(client.getAccount()));

        clientDAO.update(client);

        em.getTransaction().commit();
        em.close();
    }

    public Client getClientById(Long clientId) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();

        return clientDAO.getById(clientId);
    }

    public Iterable<Client> getAllClients() {
        return DAOFactory.getClientDAO().getAll();
    }

    public void close() {
        System.out.println("jaaaaa gesloten!");
    }
}
