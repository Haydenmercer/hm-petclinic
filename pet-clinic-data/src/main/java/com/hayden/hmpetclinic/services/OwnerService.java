package com.hayden.hmpetclinic.services;

import com.hayden.hmpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
