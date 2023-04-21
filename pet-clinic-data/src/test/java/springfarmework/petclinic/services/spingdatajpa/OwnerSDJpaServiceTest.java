package springfarmework.petclinic.services.spingdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springfarmework.petclinic.model.Owner;
import springfarmework.petclinic.repositories.OwnerRepositories;
import springfarmework.petclinic.repositories.PetRepositories;
import springfarmework.petclinic.repositories.PetTypeRopositories;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepositories ownerRepositories;
    @Mock
    PetRepositories petRepositories;
    @Mock
    PetTypeRopositories petTypeRopositories;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepositories.findByLastName(any())).thenReturn(owner);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepositories).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepositories.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findByID() {
        when(ownerRepositories.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner searchOwner = service.findByID(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIDNotFound() {
        when(ownerRepositories.findById(anyLong())).thenReturn(Optional.empty());
        Owner searchOwner = service.findByID(1L);
        assertNull(null);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepositories.save(any())).thenReturn(owner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepositories).save(any());
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepositories,  times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepositories).deleteById(anyLong());
    }
}