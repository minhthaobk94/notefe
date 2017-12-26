package com.thaontm.project.notefecore.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {
    T save(T entity);

    T findById(ID primaryKey);

    Iterable<T> findAll();

    long count();

    void delete(T entity);
}
