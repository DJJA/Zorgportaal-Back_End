package factory;

import authentication.AccessType;
import authentication.Account;
import authentication.Role;
import authentication.Scope;
import domain.Client;

import java.util.ArrayList;
import java.util.List;

public class MockFactory {

//    public static Client getClient() {
//        return new Client("dj")
//    }

    public static Account getAdminAccount() {
        return new Account("dj", "dj", getAdminRoles());
    }

    public static List<Role> getAdminRoles() {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("admin", MockFactory.getAdminScopes()));

        return roles;
    }

    public static List<Scope> getAdminScopes() {
        List<Scope> scopes = new ArrayList<>();

        scopes.add(new Scope("clients", AccessType.ALL));

        return scopes;
    }
}
