package springfarmework.petclinic.services.map;

import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Visit;
import springfarmework.petclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(/*visit.getPet() == null || visit.getPet().getOwner() == null ||*/ visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
