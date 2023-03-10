package springfarmework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springfarmework.petclinic.model.*;
import springfarmework.petclinic.services.OwnerService;
import springfarmework.petclinic.services.PetTypeService;
import springfarmework.petclinic.services.VetService;
import springfarmework.petclinic.services.map.SpecialtiesServiceMap;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesServiceMap specialtiesServiceMap;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesServiceMap specialtiesServiceMap) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesServiceMap = specialtiesServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
         if (count == 0) {
             loadData();
         }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType =  petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtiesServiceMap.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtiesServiceMap.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtiesServiceMap.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("koroleva 28");
        owner1.setCity("Odessa");
        owner1.setTelephone("38097000000");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("koroleva 28");
        owner2.setCity("Odessa");
        owner2.setTelephone("38097000000");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(saveCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDay(LocalDate.now());
        fionasCat.setName("Marta");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialtys().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialtys().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
