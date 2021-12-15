package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Vet;
import com.hayden.hmpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
