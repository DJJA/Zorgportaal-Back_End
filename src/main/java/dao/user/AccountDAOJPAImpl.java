package dao.user;

import authentication.Account;
import dao.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AccountDAOJPAImpl extends GenericDAO implements AccountDAO {

    public AccountDAOJPAImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Account validateUserCredentials(Account account) {
        Query query = em.createQuery("select a from Account as a where a.username = :username and a.password = :password");
        query.setParameter("username", account.getUsername());
        query.setParameter("password", account.getPassword());

        Account accountInDB = null;
        try {
            accountInDB = (Account) query.getSingleResult();
        } catch (Exception ex) {}
        return accountInDB;
    }
}
