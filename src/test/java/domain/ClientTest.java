package domain;

import factory.MockFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void equalsSameObjectTest() {
        Client client1 = new Client("Dirk-Jan", new Date(), Gender.MALE, MockFactory.getAdminAccount(), "bla bla bla help");
        Client client2 = client1;

        assertEquals(client1, client2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        Date birthday = new Date();
        Client client1 = new Client("Dirk-Jan", birthday, Gender.MALE, MockFactory.getAdminAccount(), "bla bla bla help");
        Client client2 = new Client("Dirk-Jan", birthday, Gender.MALE, MockFactory.getAdminAccount(), "bla bla bla help");;

        assertEquals(client1, client2);
    }
}