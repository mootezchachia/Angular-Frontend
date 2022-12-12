package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Train;
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
}