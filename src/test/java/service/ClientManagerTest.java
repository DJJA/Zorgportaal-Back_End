package service;

import authentication.Account;
import domain.Client;
import domain.Gender;
import factory.DatabaseType;
import factory.HibernateFactory;
import factory.ManagerFactory;
import factory.MockFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ClientManagerTest {

    @Before
    public void setUp() throws Exception {
        new DatabaseCleaner(HibernateFactory.getEntityManager()).clean();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addClientGetClient() {
        HibernateFactory.setDatabaseType(DatabaseType.TEST);
        ClientManager clientManager = ManagerFactory.getClientManager();
        Client client1 = new Client("Dirk-Jan", new Date(), Gender.MALE, MockFactory.getAdminAccount(),"bla bla bla help hem");

        clientManager.addClient(client1);

        List<Client> clients = (List) ManagerFactory.getClientManager().getAllClients();

        assertEquals(1, clients.size());

        Client client2 = ManagerFactory.getClientManager().getClientById(clients.get(0).getId());

        assertEquals(client1, client2);
    }
}