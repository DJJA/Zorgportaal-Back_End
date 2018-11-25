package authentication;

import javax.persistence.*;

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

    public Account() {
        // Required for Hiberante
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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

        return true;
    }
}
