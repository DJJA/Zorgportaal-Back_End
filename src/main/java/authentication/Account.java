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
}
