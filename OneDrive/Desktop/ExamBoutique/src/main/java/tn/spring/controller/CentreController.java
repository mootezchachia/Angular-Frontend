package tn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.CentreCommercial;
import tn.spring.services.ICentreService;

@RestController
public class CentreController {
	
	@Autowired
	ICentreService centreService;

	@PostMapping("/add-centre")
	@ResponseBody
	public void ajouCentre(@RequestBody CentreCommercial centre) {
		centreService.ajouCentre(centre);
	}
}
