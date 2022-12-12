package tn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.Boutique;
import tn.spring.services.IBoutiqueService;

@RestController
public class BoutiqueController {
	
	@Autowired
	IBoutiqueService boutiqueService;
	
	@PostMapping("/add-listeBoutique/{idCentre}")
	@ResponseBody
	void ajouterEtaffecterListeboutique(@RequestBody List<Boutique> lb,@PathVariable("idCentre") Long idCentre) {
		boutiqueService.ajouterEtaffecterListeboutique(lb, idCentre);
	}
	
	@GetMapping("/liste-boutique/{idCentre}")
	@ResponseBody
	List<Boutique> listedeBoutiques(@PathVariable("idCentre") Long idCentre){
		return boutiqueService.listedeBoutiques(idCentre);
	}

}
