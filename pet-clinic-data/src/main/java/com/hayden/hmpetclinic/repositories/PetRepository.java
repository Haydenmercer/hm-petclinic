package com.hayden.hmpetclinic.repositories;

import com.hayden.hmpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
