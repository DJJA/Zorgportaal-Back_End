package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HibernateFactory {
//    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static EntityManagerFactory entityManagerFactory = new Configuration().configure().buildSessionFactory();

//    public static Session getSsession() { return sessionFactory.openSession(); }
    public static EntityManager getEntityManager() { return entityManagerFactory.createEntityManager(); }
}
