package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Visit;
import springfarmework.petclinic.repositories.VisitRepositories;
import springfarmework.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepositories visitRepositories;

    public VisitSDJpaService(VisitRepositories visitRepositories) {
        this.visitRepositories = visitRepositories;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepositories.findAll().forEach(visits::add);
        return  visits;
    }

    @Override
    public Visit findByID(Long id) {
        return visitRepositories.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepositories.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepositories.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepositories.deleteById(id);
    }
}
