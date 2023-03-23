package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Owner;

public interface OwnerRepositories extends CrudRepository<Owner, Long> {
}
