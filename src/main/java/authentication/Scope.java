package authentication;

import javax.persistence.*;

@Entity
@Table(name = "Scope", uniqueConstraints = @UniqueConstraint(columnNames = {"ResourceName", "AccessType"}))
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "ResourceName")
    private String resourceName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "AccessType")
    private AccessType accessType;

    public Scope() {
        // Required for Hibernate
    }

    public Scope(String resourceName, AccessType accessType) {
        this.resourceName = resourceName;
        this.accessType = accessType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Scope scope = (Scope) obj;
        if (!this.resourceName.equals(scope.resourceName)) return false;
        if (this.accessType == null ? scope.accessType != null : !this.accessType.equals(scope.accessType)) return false;

        return true;
    }
}
