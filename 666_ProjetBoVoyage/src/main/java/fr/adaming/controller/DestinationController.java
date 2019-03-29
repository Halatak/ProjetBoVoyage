package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/destination")
@Scope("session")
public class DestinationController {

	@Autowired
	private IDestinationService destService;
	
	// Liste Destination
		@RequestMapping(value = "/destinationListe", method = RequestMethod.GET)
		public ModelAndView afficheListe() {
			return new ModelAndView("listeDestination", "destinationListe", destService.afficherListeDestinationService());
		}

		// Fonctionnalité ajouter
		@RequestMapping(value = "/destinationAfficheAjouter", method = RequestMethod.GET)
		public String afficheAjout(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("desAjout", new Destination());
			return "ajouterdestination";
		}

		@RequestMapping(value = "/destinationSoumettreAjouter", method = RequestMethod.POST)
		public String soumettreAjout(ModelMap modele, @ModelAttribute("desAjout") Destination desIn, RedirectAttributes ra) {
			// Appel de la méthode service
			Destination desOut = destService.ajoutDestinationService(desIn);
			if (desOut.getIdDestination() != 0) {
				return "redirect:destinationListe";
			} else {
				ra.addFlashAttribute("msg", "l'ajout a échoué");
				return "redirect:destinationAfficheAjout";
			}
		}

		// Modification
		@RequestMapping(value = "/destinationAfficheModifier", method = RequestMethod.GET)
		public String afficheModif(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("desModif", new Destination());

			return "modifierDestination";
		}

		@RequestMapping(value = "/destinationSoumettreModifier", method = RequestMethod.POST)
		public String soumettreModif(ModelMap modele, @ModelAttribute("desModif") Destination desIn, RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				destService.modifierDestinationService(desIn);;
				return "redirect:destinationListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "modif a échoué");
				return "redirect:destinationAfficheModifier";
			}

		}

		// Suppression
		@RequestMapping(value = "/destinationAfficheSupprimer", method = RequestMethod.GET)
		public String afficheSuppr(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("desSuppr", new Destination());

			return "supprimerDestination";
		}

		@RequestMapping(value = "/destinationSoumettreSupprimer", method = RequestMethod.POST)
		public String soumettreSuppr(ModelMap modele, @ModelAttribute("desSuppr") Destination desIn, RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				destService.supprDestinationService(desIn);
				return "redirect:destinationListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "suppr a échoué");
				return "redirect:destinationAfficheSupprimer";
			}

		}

		// Rechercher
		@RequestMapping(value = "/destinationAfficheRechercher", method = RequestMethod.GET)
		public String afficheSearch(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("desSearch", new Destination());

			return "rechercheDestination";
		}

		// Rechercher
		@RequestMapping(value = "/destinationSoumettreSearch", method = RequestMethod.POST)
		public ModelAndView soumettreSearch(@ModelAttribute("desSearch") Destination desIn, RedirectAttributes ra) {
			// Appel de la méthode service

			Destination desOut = destService.getDestinationByIdService(desIn.getIdDestination());
			if (desOut != null) {
				return new ModelAndView("recherchedestination", "destination", desOut);
			} else {
				ra.addFlashAttribute("msg", "recherche a échoué");
				return new ModelAndView("redirect:destinationAfficheRechercher");
			}

		}

		@RequestMapping(value = "/destinationSoumettre-supprLien", method = RequestMethod.GET)
		public String suppLien(@RequestParam("pId") int id) {
			destService.supprDestinationByIdService(id);
			return "redirect:destinationListe";
		}

		@RequestMapping(value = "/destinationSoumettre-modifLien", method = RequestMethod.GET)
		public String modifLien(Model modele, @RequestParam("pId") int id) {
			Destination desOut = destService.getDestinationByIdService(id);
			modele.addAttribute("desModif", desOut);
			return "modifierDestination";
		}
}
