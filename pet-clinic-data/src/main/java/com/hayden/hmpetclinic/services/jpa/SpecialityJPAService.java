package com.hayden.hmpetclinic.services.jpa;

import com.hayden.hmpetclinic.model.Specialty;
import com.hayden.hmpetclinic.repositories.SpecialtyRepository;
import com.hayden.hmpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class SpecialityJPAService implements SpecialtyService {

    private SpecialtyRepository specialtyRepository;

    public SpecialityJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty findByID(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty save(Specialty obj) {
        return specialtyRepository.save(obj);
    }

    @Override
    public void delete(Specialty obj) {
        specialtyRepository.delete(obj);
    }

    @Override
    public void deleteByID(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
