package tn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Boutique;
import tn.spring.entities.CentreCommercial;
import tn.spring.repository.BoutiqueRepository;
import tn.spring.repository.CentreCommercialRepository;

@Service
public class BoutiqueServiceImpl implements IBoutiqueService {

	@Autowired
	BoutiqueRepository boutiqueRepository;
	@Autowired
	CentreCommercialRepository centreRepository;

	@Override
	public void ajouterEtaffecterListeboutique(List<Boutique> lb, Long idCentre) {
		boutiqueRepository.saveAll(lb);
		CentreCommercial centre = centreRepository.findById(idCentre).orElse(null);
		for (Boutique boutique : lb) {
			boutique.setCentreCommercial(centre);
		}
		boutiqueRepository.saveAll(lb);
	}

	@Override
	public List<Boutique> listedeBoutiques(Long idCentre) {
		CentreCommercial centre = centreRepository.findById(idCentre).orElse(null);
		return boutiqueRepository.findByCentreCommercial(centre);
	}

}
