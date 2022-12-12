package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Voyageur;

@Repository
public interface VoyageurRepository extends JpaRepository<Voyageur, Long> {
}