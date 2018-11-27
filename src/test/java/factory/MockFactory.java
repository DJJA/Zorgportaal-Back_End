package factory;

import authentication.AccessType;
import authentication.Role;
import authentication.Scope;

import java.util.ArrayList;
import java.util.List;

public class MockFactory {

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
