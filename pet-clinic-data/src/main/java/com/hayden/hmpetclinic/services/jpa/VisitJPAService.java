package com.hayden.hmpetclinic.services.jpa;

import com.hayden.hmpetclinic.model.Visit;
import com.hayden.hmpetclinic.repositories.VisitRepository;
import com.hayden.hmpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class VisitJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findByID(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit save(Visit obj) {
        return visitRepository.save(obj);
    }

    @Override
    public void delete(Visit obj) {
        visitRepository.delete(obj);
    }

    @Override
    public void deleteByID(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
