package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.PetType;
import springfarmework.petclinic.repositories.PetTypeRopositories;
import springfarmework.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRopositories petTypeRopositories;

    public PetTypeSDJpaService(PetTypeRopositories petTypeRopositories) {
        this.petTypeRopositories = petTypeRopositories;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRopositories.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findByID(Long id) {
        return petTypeRopositories.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRopositories.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRopositories.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRopositories.deleteById(id);
    }
}
