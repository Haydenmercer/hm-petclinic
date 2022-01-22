package com.hayden.hmpetclinic.repositories;

import com.hayden.hmpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
