package dao;

import javax.persistence.EntityManager;

public interface DAO <T> {
    Iterable<T> getAll();
    T getById(Long id);
    T add(T value);
    T update(T value);

    EntityManager getEntityMangaer();
}
