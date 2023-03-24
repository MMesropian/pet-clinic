package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Owner;
import springfarmework.petclinic.repositories.OwnerRepositories;
import springfarmework.petclinic.repositories.PetRepositories;
import springfarmework.petclinic.repositories.PetTypeRopositories;
import springfarmework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepositories ownerRepositories;
    private final PetRepositories petRepositories;
    private final PetTypeRopositories petTypeRopositories;

    public OwnerSDJpaService(OwnerRepositories ownerRepositories, PetRepositories petRepositories,
                             PetTypeRopositories petTypeRopositories) {
        this.ownerRepositories = ownerRepositories;
        this.petRepositories = petRepositories;
        this.petTypeRopositories = petTypeRopositories;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepositories.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findByID(Long id) {
        return ownerRepositories.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepositories.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepositories.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        ownerRepositories.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositories.findByLastName(lastName);
    }
}
