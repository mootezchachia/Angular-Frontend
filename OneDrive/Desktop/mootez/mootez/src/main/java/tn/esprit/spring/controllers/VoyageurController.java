package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repositories.VoyageurRepository;

@RestController
@RequestMapping("/voyageur")
public class VoyageurController {

    VoyageurRepository voyageurRepository;
    @Autowired
    public VoyageurController(VoyageurRepository voyageurRepository) {
        this.voyageurRepository = voyageurRepository;

    }
    @PostMapping("/add")
    public void ajouterVoyageur(@RequestBody Voyageur voyageur){
        voyageurRepository.save(voyageur);
    }
}
