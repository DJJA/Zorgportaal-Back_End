package authentication;

import factory.MockFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void equalsSameObjectTest() {
        List<Role> roles = MockFactory.getAdminRoles();
        Account account1 = new Account("dj", "dj", roles);
        Account account2 = account1;

        assertEquals(account1, account2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        List<Role> roles1 = MockFactory.getAdminRoles();
        List<Role> roles2 = MockFactory.getAdminRoles();
        Account account1 = new Account("dj", "dj", roles1);
        Account account2 = new Account("dj", "dj", roles2);

        assertEquals(account1, account2);
    }
}