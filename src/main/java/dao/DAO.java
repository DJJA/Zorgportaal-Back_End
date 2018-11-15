package dao;

import java.util.Collection;

public interface DAO <T> {
    Iterable<T> getAll();
//    T getById()
    T add(T value);
    T update(T value);
}
