package service;

import authentication.Account;
import domain.Client;
import domain.Gender;
import factory.ManagerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientManagerTest {

    @Test
    public void addClient() {
        ClientManager clientManager = ManagerFactory.getClientManager();
        Client client1 = new Client("Dirk-Jan", new Date(), Gender.MALE, "bla bla bla help hem");
        Account account = new Account("dj", "dj");
        client1.setAccount(account);

        clientManager.addClient(client1);

//        Client client2 = ManagerFactory.getClientManager().getClientById(1L);

//        Assert.assertEquals(client1, client2);
    }
}