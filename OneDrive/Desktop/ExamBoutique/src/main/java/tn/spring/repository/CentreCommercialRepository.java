package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.CentreCommercial;

@Repository
public interface CentreCommercialRepository extends JpaRepository<CentreCommercial,Long>{

}
