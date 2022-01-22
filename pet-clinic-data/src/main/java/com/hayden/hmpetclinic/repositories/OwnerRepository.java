package com.hayden.hmpetclinic.repositories;

import com.hayden.hmpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
