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

    public HealthRating() {
        // Needed for Hibernate
    }

    public HealthRating(Long id) {  // TODO: Review all domain classes and determine what properties can be null and update the equals methods and corresponding tests
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        HealthRating healthRating = (HealthRating) obj;
        if (this.id == null ? healthRating.id != null : !this.id.equals(healthRating.id)) return false;
        if (this.rating != healthRating.rating) return false;
        if (!this.date.equals(healthRating.date)) return false;

        return true;
    }
}
