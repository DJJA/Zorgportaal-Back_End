package service;

import authentication.Account;
import domain.Client;
import domain.Gender;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientManagerTest {

    @Test
    public void addClient() {
        ClientManager mgr = new ClientManager();

        Client client = new Client("Dirk-Jan", new Date(), Gender.MALE, "bla bla bla help hem");

        Account account = new Account("dj", "dj");

        client.setAccount(account);

        mgr.addClient(client);
    }
}