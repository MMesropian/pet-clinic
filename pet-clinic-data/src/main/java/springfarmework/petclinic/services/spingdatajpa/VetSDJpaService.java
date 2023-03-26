package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Vet;
import springfarmework.petclinic.repositories.VetRepositories;
import springfarmework.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepositories vetRepositories;

    public VetSDJpaService(VetRepositories vetRepositories) {
        this.vetRepositories = vetRepositories;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepositories.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findByID(Long id) {
        return vetRepositories.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepositories.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepositories.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepositories.deleteById(id);
    }
}
