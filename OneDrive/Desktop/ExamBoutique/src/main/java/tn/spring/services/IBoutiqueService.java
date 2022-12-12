package tn.spring.services;

import java.util.List;

import tn.spring.entities.Boutique;

public interface IBoutiqueService {

	void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre);
	List<Boutique> listedeBoutiques(Long idCentre);
}
