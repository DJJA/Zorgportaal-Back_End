package service;

import domain.HealthRating;
import factory.HibernateFactory;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import java.util.Date;

import static org.junit.Assert.*;

public class HealthRatingManagerTest {

    @Before
    public void setUp() throws Exception {
        new DatabaseCleaner(HibernateFactory.getEntityManager()).clean();
    }

    @Test
    public void addHealthRating() {
        HealthRatingManager mgr = new HealthRatingManager();

        HealthRating hr = new HealthRating();
        hr.setRating(2);
        hr.setDate(new Date());

        mgr.addHealthRating(hr);
    }
}