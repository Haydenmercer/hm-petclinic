package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Person;
import com.hayden.hmpetclinic.model.Pet;
import com.hayden.hmpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}