package springfarmework.petclinic.services.map;

import springfarmework.petclinic.model.Specialty;
import springfarmework.petclinic.services.CrudService;
import springfarmework.petclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtiesServiesMap extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
