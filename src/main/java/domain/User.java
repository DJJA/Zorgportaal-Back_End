package domain;

import authentication.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AccountId")
    private Account account;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Birthday", nullable = false)
    private Date birthday;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Gender", nullable = false)
    private Gender gender;

    public User() {
        // Needed for Hibernate
    }

    public User(String name, Date birthday, Gender gender, Account account) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.account = account;
    }

    public User(Long id, String name, Date birthday, Gender gender, Account account) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        System.out.println(obj.getClass());
        System.out.println(this.getClass());

        User user = (User) obj;
        if (this.id == null) {                                  // TODO: Deal with nullable items, and write tests for there
            if (user.id != null) return false;
        } else {
            if (!this.id.equals(user.id)) return false;
        }
        if (!this.account.equals(user.account)) return false;   // TODO: Is this possible? Private field no getter ...
        if (!this.name.equals(user.name)) return false;
        if (!this.birthday.equals(user.birthday)) return false;
        if (!this.gender.equals(user.gender)) return false;

        return true;
    }
}
