package domain;

import authentication.Account;
import factory.MockFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MentorTest {
    @Test
    public void equalsSameObjectTest() {
        Account account = new Account("dj", "dj", MockFactory.getAdminRoles());
        Mentor mentor1 = new Mentor("Dirk-Jan", new Date(), Gender.MALE, account, "HBO mensen helpen");
        Mentor mentor2 = mentor1;

        assertEquals(mentor1, mentor2);
    }

    @Test
    public void equalsDifferentObjectSameValuesTest() {
        Account account = new Account("dj", "dj", MockFactory.getAdminRoles());
        Date birthday = new Date();
        Mentor mentor1 = new Mentor("Dirk-Jan", birthday, Gender.MALE, account, "HBO mensen helpen");
        Mentor mentor2 = new Mentor("Dirk-Jan", birthday, Gender.MALE, account, "HBO mensen helpen");

        assertEquals(mentor1, mentor2);
    }
}