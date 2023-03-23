package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Visit;

public interface VisitRepositories extends CrudRepository<Visit, Long> {
}
