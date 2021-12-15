package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Owner;
import com.hayden.hmpetclinic.services.CrudService;
import com.hayden.hmpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(lastName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
