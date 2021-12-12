package com.hayden.hmpetclinic.services;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

//Why isn't this an abstract class with methods that make use of generics?
public interface CrudService<T, ID> {

    public T findByID(ID id);

    Set<T> findAll();

    <S extends T> S save(S obj);

    void delete(T obj);

    void deleteByID(ID id);

}
