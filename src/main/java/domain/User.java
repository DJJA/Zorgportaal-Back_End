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

    public User(String name, Date birthday, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
