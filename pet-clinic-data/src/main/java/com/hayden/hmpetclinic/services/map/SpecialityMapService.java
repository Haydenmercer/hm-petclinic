package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Specialty;
import com.hayden.hmpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "map")
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
