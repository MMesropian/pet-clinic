package springfarmework.petclinic.services.map;

import org.springframework.stereotype.Component;
import springfarmework.petclinic.model.Pet;

import java.util.Set;

@Component
public class PetServiceMap extends AbstractMapService<Pet, Long> {
    @Override
    Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    Pet save(Long aLong, Pet object) {
        return super.save(aLong, object);
    }

    @Override
    void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    void delete(Pet object) {
        super.delete(object);
    }
}
