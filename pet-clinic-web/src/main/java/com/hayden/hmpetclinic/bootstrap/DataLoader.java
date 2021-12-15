package com.hayden.hmpetclinic.bootstrap;

import com.hayden.hmpetclinic.model.Owner;
import com.hayden.hmpetclinic.model.Vet;
import com.hayden.hmpetclinic.services.OwnerService;
import com.hayden.hmpetclinic.services.VetService;
import com.hayden.hmpetclinic.services.map.OwnerMapService;
import com.hayden.hmpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setLastName("Drinkwater");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
