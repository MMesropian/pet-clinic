package springfarmework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Specialty;
import springfarmework.petclinic.services.CrudService;
import springfarmework.petclinic.services.SpecialtiesService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtiesServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

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
