package tn.esprit.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voyage")
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voyage", nullable = false)
    private Long idVoyage;

    @Column(name = "code_voyage")
    private String codeVoyage;


    @Column(name = "heure_depart")
    private Double heureDepart;

    @Column(name = "heure_arrive")
    private Double heureArrive;

    @Column(name = "date_depart")
    private Date dateDepart;

    @Column(name = "date_arrive")
    private Date dateArrive;

    @Enumerated(EnumType.STRING)
    @Column(name = "gare_depart")
    private Ville gareDepart;

    @Enumerated(EnumType.STRING)
    @Column(name = "gare_arrive")
    private Ville gareArrive;

    @ManyToMany(mappedBy = "voyages")
    private Set<Voyageur> voyageurs = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "train_id_train")
    private Train train;

}