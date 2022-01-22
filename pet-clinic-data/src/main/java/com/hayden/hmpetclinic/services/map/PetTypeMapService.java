package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.PetType;
import com.hayden.hmpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "map")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

}
