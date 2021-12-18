package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.PetType;
import com.hayden.hmpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

}
