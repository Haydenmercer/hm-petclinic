package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Owner;
import com.hayden.hmpetclinic.model.Pet;
import com.hayden.hmpetclinic.model.PetType;
import com.hayden.hmpetclinic.services.OwnerService;
import com.hayden.hmpetclinic.services.PetService;
import com.hayden.hmpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Profile(value = "map")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    //Used to persist associated objects
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(lastName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner owner){
        if(owner != null){
            if(owner.getPets() != null){ //This is not required if the set is being initialized on creation.
                owner.getPets().forEach(pet -> { //Surely this can be refactored. E.g. implement saving of PetType in Pet's save() method.
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){ //If no ID, then it hasn't been saved.
                            pet.setPetType(petTypeService.save(pet.getPetType())); //Ensure the pet.petType is set to the returned object with ID.
                        }
                    }
                    else{
                        throw new RuntimeException("PetType is required");
                    }
                    if(pet.getId() == null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(owner);
        }
        else{
            return null;
        }
    }
}
