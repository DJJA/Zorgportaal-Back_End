package service;

import authentication.Account;
import domain.Client;
import domain.Gender;
import factory.DatabaseType;
import factory.HibernateFactory;
import factory.ManagerFactory;
import factory.MockFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientManagerTest {

    @Test
    public void addClientGetClient() {
        HibernateFactory.setDatabaseType(DatabaseType.TEST);
        ClientManager clientManager = ManagerFactory.getClientManager();
        Client client1 = new Client("Dirk-Jan", new Date(), Gender.MALE, new Account("dj", "dj", MockFactory.getAdminRoles()),"bla bla bla help hem");

        clientManager.addClient(client1);

        Client client2 = ManagerFactory.getClientManager().getClientById(1L);

        assertEquals(client1, client2);
    }
}