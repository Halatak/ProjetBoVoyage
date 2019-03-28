package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/voyage")
public class VoyageController {
	
	// transformation assoc uml en java
	@Autowired
	private IVoyageService voyageService;

	//Methode pour convertir et afficher correctement les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//l'objet WebDataBinder sert à faire le lien entre les params de la requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		//la methode registerCustomEditor: à configurer la conversion du param recu au type de l'attribut

		//l'objet CustomDateEditor: sert à lier la date recue comme params de la requete à l'attribut de l'objet etudiant

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	//page d'accueil qui affiche la liste des voyages
	@RequestMapping(value="/liste", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("accueil", "liste", voyageService.afficherListeVoyageService());
	}

}
