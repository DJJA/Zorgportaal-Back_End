package domain;

import authentication.Account;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void equalsSameObjectTest() {
        Account account = new Account("dj", "dj");
        Client client1 = new Client("Dirk-Jan", new Date(), Gender.MALE, account, "bla bla bla help");
        Client client2 = client1;

        assertEquals(client1, client2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        Account account = new Account("dj", "dj");
        Date birthday = new Date();
        Client client1 = new Client("Dirk-Jan", birthday, Gender.MALE, account, "bla bla bla help");
        Client client2 = new Client("Dirk-Jan", birthday, Gender.MALE, account, "bla bla bla help");;

        assertEquals(client1, client2);
    }
}