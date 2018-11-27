package service;

import domain.Gender;
import domain.Mentor;
import factory.DatabaseType;
import factory.HibernateFactory;
import factory.ManagerFactory;
import factory.MockFactory;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MentorManagerTest {

    @Before
    public void setUp() throws Exception {
        new DatabaseCleaner(HibernateFactory.getEntityManager()).clean();
    }

    @Test
    public void addMentorGetMentor() {
        HibernateFactory.setDatabaseType(DatabaseType.TEST);
        Mentor mentor1 = new Mentor("Dirk-Jan", new Date(), Gender.MALE, MockFactory.getAdminAccount(),"HBO Physologie");

        ManagerFactory.getMentorManager().addMentor(mentor1);

        List<Mentor> mentors = (List) ManagerFactory.getMentorManager().getAllMentors();

        assertEquals(1, mentors.size());

        Long id = mentors.get(0).getId();

        Mentor mentor2 = ManagerFactory.getMentorManager().getMentorById(id);   // TODO: Persist should return last added id, this needs to be 2 because it ran the client manager test first

        assertEquals(mentor1, mentor2);
    }
}