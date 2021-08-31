package dev.schoolmanagement.service;

import java.util.List;

public interface BaseService<T> {
    T save(T t);

    List<T> findAll();

    T findById(long id);

    void delete(T t);

    void deleteById(long id);

    T update(T t);
}
