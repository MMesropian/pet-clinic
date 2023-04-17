package springfarmework.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name ="vets_id"), inverseJoinColumns = @JoinColumn(name = "specialties_id"))
    private Set<Specialty> specialties = new HashSet<>();

}
