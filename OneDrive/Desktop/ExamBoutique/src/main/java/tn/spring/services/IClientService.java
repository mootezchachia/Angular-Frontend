package tn.spring.services;

import java.util.List;

import tn.spring.entities.Categorie;
import tn.spring.entities.Client;

public interface IClientService {
	void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
	List<Client> listedeClients(Long idBoutique);
	List<Client> listeDeClientsParCategorie(Categorie categorie);
}
