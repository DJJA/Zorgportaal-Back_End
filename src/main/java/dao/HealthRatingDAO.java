package dao;

import domain.HealthRating;

public interface HealthRatingDAO extends DAO<HealthRating> {
    void delete(HealthRating healthRating);
    Iterable<HealthRating> getClientsHealthRatings(Long clientId);
}
