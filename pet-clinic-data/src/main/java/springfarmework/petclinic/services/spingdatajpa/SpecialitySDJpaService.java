package springfarmework.petclinic.services.spingdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Specialty;
import springfarmework.petclinic.repositories.SpecialtyRepositories;
import springfarmework.petclinic.services.SpecialtiesService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtiesService {

    private final SpecialtyRepositories specialtiesService;

    public SpecialitySDJpaService(SpecialtyRepositories specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtiesService.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findByID(Long id) {
        return specialtiesService.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtiesService.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtiesService.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtiesService.deleteById(id);
    }
}
