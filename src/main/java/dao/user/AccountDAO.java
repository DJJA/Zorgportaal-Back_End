package dao.user;

import authentication.Account;

public interface AccountDAO {
    Account validateUserCredentials(Account account);
}
