package com.hayden.hmpetclinic.services;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CrudService<T, ID> {

    public T findByID(ID id);

    Set<T> findAll();

    T save(T obj);

    void delete(T obj);

    void deleteByID(ID id);

}
