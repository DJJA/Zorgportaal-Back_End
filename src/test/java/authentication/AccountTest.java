package authentication;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void equalsSameObjectTest() {
        Account account1 = new Account("dj", "dj");
        Account account2 = account1;

        assertEquals(account1, account2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        Account account1 = new Account("dj", "dj");
        Account account2 = new Account("dj", "dj");

        assertEquals(account1, account2);
    }
}