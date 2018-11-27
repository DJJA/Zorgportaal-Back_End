package authentication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Role_Scope",
            joinColumns = @JoinColumn(name = "RoleId"),
            inverseJoinColumns = @JoinColumn(name = "ScopeId")
    )
    private List<Scope> scopes = new ArrayList<>();

    public List<Scope> getScopes() {
        return scopes;
    }

    public Role() {
        // Required for Hibernate
    }

    public Role(String name, List<Scope> scopes) {
        this.name = name;
        this.scopes = scopes;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Role role = (Role) obj;
        if (!this.name.equals(role.name)) return false;
        if (this.scopes == null ? role.scopes != null : !this.scopes.equals(role.scopes)) return false;

        return true;
    }
}
