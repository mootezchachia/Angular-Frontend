package tn.spring.services;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Boutique;
import tn.spring.entities.CentreCommercial;
import tn.spring.repository.BoutiqueRepository;
import tn.spring.repository.CentreCommercialRepository;

@Service
public class CentreServiceImpl implements ICentreService {

	@Autowired
	CentreCommercialRepository centreRepository;
	@Autowired
	BoutiqueRepository boutiqueRepository;

	@Override
	public void ajouCentre(CentreCommercial centre) {
		Boutique boutique = saveBoutique(centre);
		boutique.setCentreCommercial(centre);
		centreRepository.save(centre);
	}

	private Boutique saveBoutique(CentreCommercial centre) {
		Set<Boutique> boutiques = (Set<Boutique>) centre.getBoutiques();
		for (Boutique boutique : boutiques) {
			return boutiqueRepository.save(boutique);
		}
		return null;
	}

}
