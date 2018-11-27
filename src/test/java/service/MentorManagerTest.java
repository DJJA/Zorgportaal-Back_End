package service;

import authentication.Account;
import domain.Gender;
import domain.Mentor;
import factory.DatabaseType;
import factory.HibernateFactory;
import factory.ManagerFactory;
import factory.MockFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MentorManagerTest {

    @Test
    public void addMentorGetMentor() {
        HibernateFactory.setDatabaseType(DatabaseType.TEST);
        Mentor mentor1 = new Mentor("Dirk-Jan", new Date(), Gender.MALE, new Account("dj", "dj", MockFactory.getAdminRoles()),"HBO Physologie");

        ManagerFactory.getMentorManager().addMentor(mentor1);

        Mentor mentor2 = ManagerFactory.getMentorManager().getMentorById(1L);

        assertEquals(mentor1, mentor2);
    }
}