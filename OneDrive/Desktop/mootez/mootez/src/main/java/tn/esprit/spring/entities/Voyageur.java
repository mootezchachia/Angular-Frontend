package tn.esprit.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voyageur")
public class Voyageur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVoyageur", nullable = false)
    private Long idVoyageur;

    @Column(name = "nom_voyageur")
    private String nomVoyageur;

    @ManyToMany
    @JoinTable(name = "voyageur_voyages",
            joinColumns = @JoinColumn(name = "voyageur_id_voyageur"),
            inverseJoinColumns = @JoinColumn(name = "voyages_id_voyage"))
    private Set<Voyage> voyages = new LinkedHashSet<>();

}