package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Pet;
import springfarmework.petclinic.repositories.PetRepositories;
import springfarmework.petclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    public final PetRepositories petRepositories;

    public PetSDJpaService(PetRepositories petRepositories) {
        this.petRepositories = petRepositories;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepositories.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findByID(Long id) {
        return petRepositories.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepositories.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepositories.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepositories.deleteById(id);
    }
}
