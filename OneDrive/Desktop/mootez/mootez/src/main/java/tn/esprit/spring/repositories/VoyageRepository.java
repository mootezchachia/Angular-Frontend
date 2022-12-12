package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    Optional<Voyage> findByGareDepartEqualsAndGareArriveEqualsAndHeureDepart(Ville gareDepart, Ville gareArrive, Double heureDepart);

    List<Voyage> findByGareDepartEquals(Ville gareDepart);

    List<Voyage> findByDateArriveLessThan(Date dateArrive);

}