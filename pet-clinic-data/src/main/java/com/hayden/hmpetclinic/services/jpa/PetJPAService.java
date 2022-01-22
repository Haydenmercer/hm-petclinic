package com.hayden.hmpetclinic.services.jpa;

import com.hayden.hmpetclinic.model.Pet;
import com.hayden.hmpetclinic.repositories.PetRepository;
import com.hayden.hmpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class PetJPAService implements PetService {

    private final PetRepository petRepository;

    public PetJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findByID(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet obj) {
        return petRepository.save(obj);
    }

    @Override
    public void delete(Pet obj) {
        petRepository.delete(obj);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
