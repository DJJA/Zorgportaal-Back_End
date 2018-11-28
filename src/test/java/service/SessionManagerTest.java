package service;

import authentication.util.UserCredentials;
import domain.Client;
import exceptions.TokenGenerationException;
import exceptions.UserNotAuthenticatedException;
import factory.DatabaseType;
import factory.HibernateFactory;
import factory.ManagerFactory;
import factory.MockFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import static org.junit.Assert.*;

public class SessionManagerTest {

    @Before
    public void setUp() throws Exception {
        new DatabaseCleaner(HibernateFactory.getEntityManager()).clean();
    }

    @Test
    public void correctCredentials() {
        HibernateFactory.setDatabaseType(DatabaseType.TEST);
        Client client = MockFactory.getClient();
        ManagerFactory.getClientManager().addClient(client);

        UserCredentials userCredentials = new UserCredentials(client.getAccount().getUsername(), client.getAccount().getPassword());
        String jwt = "";
        try {
            jwt = ManagerFactory.getSessionManager().authenticateUser(userCredentials);
        } catch (UserNotAuthenticatedException e) {
            Assert.fail();
        } catch (TokenGenerationException e) {
            Assert.fail();
        }

        assertFalse(jwt.isEmpty());
        System.out.println(jwt);

        // TODO: JWT check
    }
}