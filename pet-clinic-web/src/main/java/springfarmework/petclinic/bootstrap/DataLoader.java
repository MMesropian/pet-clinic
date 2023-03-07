package springfarmework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springfarmework.petclinic.model.Owner;
import springfarmework.petclinic.model.PetType;
import springfarmework.petclinic.model.Vet;
import springfarmework.petclinic.services.OwnerService;
import springfarmework.petclinic.services.PetTypeService;
import springfarmework.petclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType =  petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
