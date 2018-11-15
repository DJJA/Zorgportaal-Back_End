package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HealthRating")
public class HealthRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Rating", nullable = false)
    private int rating;

    @Column(name = "Date", nullable = false)
    private Date date;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 10) throw new IllegalArgumentException("Only a value ranging from 1 to 10 is allowed."); // Zo'n check kan gaan kutten als je van JSON string naar object gaat; Of misschien vanuit DB
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
