package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Boutique;
import tn.spring.entities.CentreCommercial;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
	List<Boutique> findByCentreCommercial(CentreCommercial centre);
}
