package authentication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @ManyToMany
//    @JoinTable(name = "Account_Role",
//            joinColumns = @JoinColumn(name = "AccountId", referencedColumnName = "Id"),
//            inverseJoinColumns = @JoinColumn(name = "RoleId", referencedColumnName = "Id")
//            )
    @JoinTable(name = "Account_Role",
            joinColumns = @JoinColumn(name = "AccountId"),
            inverseJoinColumns = @JoinColumn(name = "RoleId")
    )
    private List<Role> roles = new ArrayList<>();

    public Account() {
        // Required for Hiberante
    }

    public Account(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Account account = (Account) obj;
        if (!this.username.equals(account.username)) return false;
        if (!this.password.equals(account.password)) return false;
        if (this.roles == null ? account.roles != null : !this.roles.equals(account.roles)) return false;

        return true;
    }
}
