package domain;

import authentication.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void equalsSameObjectTest() {
        Account account = new Account("dj", "dj");
        User user1 = new User(1L, "Dirk-Jan", new Date(), Gender.MALE, account);
        User user2 = user1;

        assertEquals(user1, user2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        Account account1 = new Account("dj", "dj");
        Account account2 = new Account("dj", "dj");
        Date birthday = new Date();
        User user1 = new User(1L, "Dirk-Jan", birthday, Gender.MALE, account1);
        User user2 = new User(1L, "Dirk-Jan", birthday, Gender.MALE, account2);

        assertEquals(user1, user2);
    }

    // TODO: Add some bad flow tests for the equals method
    // TODO: Perhaps get two different instances of the Date object, Although should be able to trust that the Data.equals method works correctly
}