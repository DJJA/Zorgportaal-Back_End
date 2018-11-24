package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HibernateFactory {
    // Default has to be production, only tests specifically specify the DatabaseType
    private static DatabaseType databaseType = DatabaseType.PRODUCTION;

    public static DatabaseType getDatabaseType() {
        return databaseType;
    }

    public static void setDatabaseType(DatabaseType databaseType) {
        HibernateFactory.databaseType = databaseType;
    }

    //    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//    private static EntityManagerFactory entityManagerFactory = new Configuration().configure().buildSessionFactory();
    private static EntityManagerFactory entityManagerFactory = null;

//    public static Session getSsession() { return sessionFactory.openSession(); }
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            if (databaseType == DatabaseType.PRODUCTION) {
                entityManagerFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            } else {
                entityManagerFactory = new Configuration().configure("test.hibernate.cfg.xml").buildSessionFactory();
            }
        }
        return entityManagerFactory.createEntityManager();
    }
}
