package tn.spring.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.entities.Boutique;
import tn.spring.entities.Categorie;
import tn.spring.entities.Client;
import tn.spring.entities.Genre;
import tn.spring.repository.BoutiqueRepository;
import tn.spring.repository.ClientRepository;

@Service
public class ClienServiceImpl implements IClientService {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	BoutiqueRepository boutiqueRepository;

	@Override
	@Transactional
	public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
		clientRepository.save(client);
		List<Boutique> boutiques = boutiqueRepository.findAll();
		for (Boutique boutique : boutiques) {
			for (Long id : idBoutiques) {
				if (boutique.getId().equals(id)) {
					boutique.getClients().add(client);
					clientRepository.save(client);
				}
			}
		}
	}

	@Override
	public List<Client> listedeClients(Long idBoutique) {
		return clientRepository.findByBoutiquesId(idBoutique);
	}

	@Override
	public List<Client> listeDeClientsParCategorie(Categorie categorie) {
		return clientRepository.findByBoutiquesCategorie(categorie);
	}

	@Scheduled(cron = "*/30 * * * * *")
	void nbreClientParGenre() {
		int nbrFeminin = clientRepository.getClientByGenre(Genre.FEMININ);
		int nbrMasculin = clientRepository.getClientByGenre(Genre.MASCULIN);
		System.out.println("Nombre des clients Feminins : " + nbrFeminin);
		System.out.println("Nombre des clients Masculins : " + nbrMasculin);

	}
}
