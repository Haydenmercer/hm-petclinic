package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Visit;
import com.hayden.hmpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return save(visit);
    }
}
