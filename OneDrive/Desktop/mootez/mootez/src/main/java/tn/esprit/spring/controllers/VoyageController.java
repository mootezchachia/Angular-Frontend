package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repositories.TrainRepository;
import tn.esprit.spring.repositories.VoyageRepository;

import java.util.Optional;

@RestController
@RequestMapping("/voyage")
public class VoyageController {

    VoyageRepository voyageRepository;
    TrainRepository trainRepository;
    @Autowired
    public VoyageController(VoyageRepository voyageRepository, TrainRepository trainRepository) {
        this.voyageRepository = voyageRepository;
        this.trainRepository = trainRepository;
    }




    @PostMapping("/addvoyage")
    public void ajouterVoyage(@RequestBody Voyage v){

        this.voyageRepository.save(v);
    }
    @PutMapping("/affecter/{idtrain}/{idVoyage}")
    public void affecterTrainAuVoyager(@PathVariable("idtrain") Long idtrain, @PathVariable("idVoyage") Long idVoyage){
        Optional<Train> train =trainRepository.findById(idtrain);
        Optional<Voyage> voyageur = voyageRepository.findById(idVoyage);

        if(train.isPresent() && voyageur.isPresent()){
            voyageur.get().setTrain(train.get());
            voyageRepository.save(voyageur.get());

        }


    }

}
