package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Formule;
import fr.adaming.service.IFormuleService;

@Controller
@RequestMapping("/formule")
@Scope("session")
public class FormuleController {
	
	// transformation de l'association UML en java
	@Autowired
	private IFormuleService fService;
	
	// Liste Destination
		@RequestMapping(value = "/formuleListe", method = RequestMethod.GET)
		public ModelAndView afficheListe() {
			return new ModelAndView("listeFormule", "formuleListe", fService.afficherListeFormuleService());
		}

		// Fonctionnalité ajouter
		@RequestMapping(value = "/formuleAfficheAjouter", method = RequestMethod.GET)
		public String afficheAjout(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("fAjout", new Formule());
			return "ajouterFormule";
		}

		@RequestMapping(value = "/formuleSoumettreAjouter", method = RequestMethod.POST)
		public ModelAndView soumettreAjout(Model modele, @ModelAttribute("fAjout") Formule fIn,
				RedirectAttributes ra) {
			// Appel de la méthode service
			Formule fOut = fService.ajoutFormuleService(fIn);
			if (fOut.getId() != 0) {
				return new ModelAndView("redirect:/conseillerMarketing/voyageCMListe");
			} else {
				ra.addFlashAttribute("msg", "l'ajout a échoué");
				return new ModelAndView("redirect:formuleAfficheAjout");
			}
		}

		// Modification
		@RequestMapping(value = "/formuleAfficheModifier", method = RequestMethod.GET)
		public String afficheModif(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("fModif", new Formule());

			return "modifierFormule";
		}

		@RequestMapping(value = "/formuleSoumettreModifier", method = RequestMethod.POST)
		public String soumettreModif(Model modele, @ModelAttribute("fModif") Formule fIn,
				RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				fService.modifierFormuleService(fIn);
				return "redirect:/conseillerMarketing/voyageCMListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "modif a échoué");
				return "redirect:formuleAfficheModifier";
			}

		}

		// Suppression
		@RequestMapping(value = "/formuleAfficheSupprimer", method = RequestMethod.GET)
		public String afficheSuppr(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("fSuppr", new Formule());

			return "supprimerFormule";
		}

		@RequestMapping(value = "/formuleSoumettreSupprimer", method = RequestMethod.POST)
		public String soumettreSuppr(ModelMap modele, @ModelAttribute("desSuppr") Formule fIn, RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				fService.supprFormuleService(fIn);
				;
				return "redirect:/conseillerMarketing/voyageCMListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "suppr a échoué");
				return "redirect:continentAfficheSupprimer";
			}

		}
	

}
