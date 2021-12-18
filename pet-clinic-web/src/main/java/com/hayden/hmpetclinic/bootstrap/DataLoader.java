package com.hayden.hmpetclinic.bootstrap;

import com.hayden.hmpetclinic.model.Owner;
import com.hayden.hmpetclinic.model.Pet;
import com.hayden.hmpetclinic.model.PetType;
import com.hayden.hmpetclinic.model.Vet;
import com.hayden.hmpetclinic.services.OwnerService;
import com.hayden.hmpetclinic.services.PetService;
import com.hayden.hmpetclinic.services.PetTypeService;
import com.hayden.hmpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    //Autowired annotation not required for constructors
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat); //Return saved object as it will contain generated ID.

        PetType dog = new PetType();
        cat.setName("Dog");
        PetType savedDog = petTypeService.save(cat);

        System.out.println("Loaded PetTypes");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
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

        /*Pet pet1 = new Pet();
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.of(1992, 3, 7));
        pet1.setPetType(savedCat);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.of(1992, 3, 7));
        pet2.setPetType(savedDog);
        petService.save(pet2);

        System.out.println("Loaded Pets");*/

    }
}
