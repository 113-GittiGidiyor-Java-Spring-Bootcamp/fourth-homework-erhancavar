package dev.schoolmanagement.service;



import org.apache.tomcat.jni.Local;

import java.util.List;

public interface LogService <T>{
    T save(T t);
    List<T> findAll();
    List<T> findAllByCreatedDate(Local createdDate);
    T findById(long id);
}
