package springfarmework.petclinic.services.map;

import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Specialty;
import springfarmework.petclinic.model.Vet;
import springfarmework.petclinic.services.SpecialtiesService;
import springfarmework.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialtys().size()>0) {
            object.getSpecialtys().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Specialty saveSpecialty = specialtiesService.save(specialty);
                    saveSpecialty.setId(saveSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
