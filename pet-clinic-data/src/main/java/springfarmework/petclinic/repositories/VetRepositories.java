package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Vet;

public interface VetRepositories extends CrudRepository<Vet, Long> {
}
