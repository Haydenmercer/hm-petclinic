package com.hayden.hmpetclinic.bootstrap;

import com.hayden.hmpetclinic.model.*;
import com.hayden.hmpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    //Autowired annotation not required for constructors
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat); //Return saved object as it will contain generated ID.

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        System.out.println("Loaded PetTypes");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Lane Road");
        owner1.setCity("Orgrimmar");
        owner1.setTelephone("07182775554");

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Geldolf");
        owner2.setAddress("123 Lane Road");
        owner2.setCity("Orgrimmar");
        owner2.setTelephone("07182775353");

        System.out.println("Loaded Owners");

        Pet pet1 = new Pet();
        pet1.setName("Toots");
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.of(1992, 3, 7));
        pet1.setPetType(savedCat);
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Pet pet2 = new Pet();
        pet1.setName("Dillon");
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.of(1992, 3, 7));
        pet2.setPetType(savedDog);
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Pets");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roger");
        vet2.setLastName("Drinkwater");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
