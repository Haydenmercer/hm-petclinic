package com.hayden.hmpetclinic.services.jpa;

import com.hayden.hmpetclinic.model.Owner;
import com.hayden.hmpetclinic.repositories.OwnerRepository;
import com.hayden.hmpetclinic.repositories.PetRepository;
import com.hayden.hmpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerJPAService ownerJPAService;

    final long ID = 1l;
    final String LAST_NAME = "Mercer";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByID() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerJPAService.findByID(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> returnSet = new HashSet<>();
        returnSet.add(returnOwner);
        when(ownerRepository.findAll()).thenReturn(returnSet);
        Set<Owner> resultSet = ownerJPAService.findAll();
        assertNotNull(resultSet);
        assertEquals(1, resultSet.size());
    }

    @Test
    void save() {
        Owner ownerTosave = Owner.builder().id(ID).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner saveResultOwner = ownerJPAService.save(ownerTosave);
        assertNotNull(saveResultOwner);
        assertEquals(ID, saveResultOwner.getId());
    }

    @Test
    void delete() {
        ownerJPAService.delete(returnOwner);
        ArgumentCaptor<Owner> argumentCaptor = ArgumentCaptor.forClass(Owner.class);
        verify(ownerRepository, times(1)).delete(argumentCaptor.capture()); //check correct owner was passed
        assertEquals(1, argumentCaptor.getValue().getId());
    }

    @Test
    void deleteByID() {
        ownerJPAService.deleteByID(ID);
        verify(ownerRepository, times(1)).deleteById(eq(ID));
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);
        assertEquals(LAST_NAME, ownerRepository.findByLastName(LAST_NAME).getLastName());
    }
}