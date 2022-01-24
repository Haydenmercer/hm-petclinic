package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final long ownerId = 1l;
    final String lastName = "Mercer";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void saveWithId() {
        long id = 2l;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithNoId(){
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByID() {
        Owner owner = ownerMapService.findByID(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void delete() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        ownerSet.forEach(ownerMapService::delete);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByID() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        ownerSet.forEach(owner -> ownerMapService.deleteByID(owner.getId()));
        assertEquals(0, ownerMapService.findAll().size());
    }


    @Test
    void testFindByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(lastName, owner.getLastName());
    }
}