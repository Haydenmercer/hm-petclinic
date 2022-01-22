package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Specialty;
import com.hayden.hmpetclinic.model.Vet;
import com.hayden.hmpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Profile(value = "map")
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final AbstractMapService<Specialty, Long> specialtyMapService;

    public VetMapService(AbstractMapService<Specialty, Long> specialtyMapService) {
        this.specialtyMapService = specialtyMapService;
    }

    @Override
    public Vet save(Vet vet){
        vet.getSpecialties()
        .stream()
        .filter(specialty -> specialty.getId() == null)
        .forEach(specialty -> specialty.setId(
                specialtyMapService.save(specialty)
                        .getId())
        );
        return super.save(vet);
    }

}
