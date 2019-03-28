package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.Formule;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/formule")
public class FormuleController {

	private Formule formule; 
	
	// transformation de l'association UML en java
	@Autowired
	private IVoyageService voyageService;
	
	

}
