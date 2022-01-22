package com.hayden.hmpetclinic.services.jpa;

import com.hayden.hmpetclinic.model.PetType;
import com.hayden.hmpetclinic.repositories.PetTypeRepository;
import com.hayden.hmpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class PetTypeJPAService implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findByID(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType save(PetType obj) {
        return petTypeRepository.save(obj);
    }

    @Override
    public void delete(PetType obj) {
        petTypeRepository.delete(obj);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
