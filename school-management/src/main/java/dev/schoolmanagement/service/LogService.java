package dev.schoolmanagement.service;


import java.util.List;

public interface LogService<T> {
    T save(T t);

    List<T> findAll();

    T findById(long id);
}
