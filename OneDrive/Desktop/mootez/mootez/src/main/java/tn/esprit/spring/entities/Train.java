package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrain", nullable = false)
    private Long idTrain;

    @Column(name = "code_train")
    private Long codeTrain;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private etatTrain etat;

    @Column(name = "nbrplace_libre", nullable = false)
    private int nbrplaceLibre;

}