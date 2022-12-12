package tn.esprit.spring.controllers;

import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repositories.TrainRepository;
import tn.esprit.spring.repositories.VoyageRepository;
import tn.esprit.spring.repositories.VoyageurRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/train")
@Slf4j
public class TrainController {

    TrainRepository trainRepository;
    VoyageurRepository voyageurRepository;
    VoyageRepository voyageRepository;

    @Autowired
    public TrainController(TrainRepository trainRepository, VoyageurRepository voyageurRepository, VoyageRepository voyageRepository) {
        this.trainRepository = trainRepository;
        this.voyageurRepository = voyageurRepository;
        this.voyageRepository = voyageRepository;
    }

    @PostMapping("/addtrain")
    public void ajouterTrain(@RequestBody Train train){
        trainRepository.save(train);
    }


    @PostMapping("/affecterTrainVoyageur/{idVoyageur}/{garedepart}/{gareArrive}/{heure}")
    public void affecterTrainAVoyageur(@PathVariable("idVoyageur") Long idVoyageur,
    		                           @PathVariable("garedepart") Ville garedepart,
    		                           @PathVariable("gareArrive") Ville gareArrive,
    		                           @PathVariable("heure") Double heure){
        Optional<Voyage> voyage = voyageRepository.findByGareDepartEqualsAndGareArriveEqualsAndHeureDepart(garedepart,gareArrive,heure);
        Optional<Voyageur>  voyageur= voyageurRepository.findById(idVoyageur);
        if(voyage.isPresent() && voyageur.isPresent()){
            if(voyage.get().getTrain().getNbrplaceLibre() != 0){
                Train train=voyage.get().getTrain();
                train.setNbrplaceLibre(train.getNbrplaceLibre()-1);
                trainRepository.save(train);
                voyage.get().setTrain(train);
                voyageRepository.save(voyage.get());
                Set<Voyage> voyages=voyageur.get().getVoyages();
                voyages.add(voyage.get());
                voyageur.get().setVoyages(voyages);
                voyageurRepository.save(voyageur.get());

            }else {
                log.info(
                        "place non dispo"
                );
            }
        }

    }
    @GetMapping("/trainplacelibre/{garedepart}")
    public int trainPlaceLibre(@RequestParam("garedepart") Ville garedepart){
        return voyageRepository.findByGareDepartEquals(garedepart).stream().map(elem->elem.getTrain())
                .map(elem->elem.getNbrplaceLibre()).reduce(0,(anc,val)->
                   anc + val
                )/voyageRepository.findByGareDepartEquals(garedepart).size();
    }
}
