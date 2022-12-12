package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repositories.TrainRepository;
import tn.esprit.spring.repositories.VoyageRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrainService {

    TrainRepository trainRepository;

    VoyageRepository voyageRepository;
    @Autowired
    public TrainService(TrainRepository trainRepository, VoyageRepository voyageRepository) {
        this.trainRepository = trainRepository;
        this.voyageRepository = voyageRepository;
    }


    @Scheduled(fixedRate = 30000)
    public void trainOnGare(){
        List<Voyage> voyages=voyageRepository.findByDateArriveLessThan(new Date(System.currentTimeMillis()));
        voyages.stream().map(elem->elem.getTrain()).forEach((elem)->{
            log.info(elem.toString());
        });
    }
}
