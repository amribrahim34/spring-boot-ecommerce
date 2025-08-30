package com.ecommerce.project.services;


import java.util.List;

public interface ServiceInterface<T> {
    List<T> findAll();
    T findById(Long theId);
    T save(T entity);
    void delete(Long theId);
}
