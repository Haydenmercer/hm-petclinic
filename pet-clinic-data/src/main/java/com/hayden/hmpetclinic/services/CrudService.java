package com.hayden.hmpetclinic.services;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CrudService<T, ID> {

    T findByID(ID id);

    Set<T> findAll();

    <S extends T> S save(S obj);

    void delete(T obj);

    void deleteByID(ID id);

}
