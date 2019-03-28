package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/voyage")
@Scope("session")
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
	@RequestMapping(value="/voyageListe", method=RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("accueil", "voyageListe", voyageService.afficherListeVoyageService());
	}
	
	// ===================== fonctionnalité ajouter voyage
	@RequestMapping(value = "/voyageAjouter", method = RequestMethod.GET)
	public String addVoyage(Model modele) {
		
		modele.addAttribute("voyAjout", new Voyage());
		return "ajoutVoyage";
	}
	
	@RequestMapping(value = "/voyageSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjout(@ModelAttribute("voyAjout") Voyage voyIn, RedirectAttributes ra) {
		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		Voyage voyOut = voyageService.ajoutVoyageService(voyIn);
		if (voyOut.getId() != 0) {
			return "redirect:listeVoyage";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:voyageAjouter";
		}

	}
	
	// ===================== fonctionnalité modifier voyage
		@RequestMapping(value = "/voyageModifier", method = RequestMethod.GET)
		public String updateVoyage(Model modele) {
			// lier un etudiant au model mvc afin de l'utiliser dans le
			modele.addAttribute("voyModif", new Voyage());
			return "modifVoyage";
		}

		@RequestMapping(value = "/voyageSoumettreModifier", method = RequestMethod.POST)
		public String soumettreModif(@ModelAttribute("voyModif") Voyage voyIn, RedirectAttributes ra) {
			try {
				voyageService.modifierVoyageService(voyIn);
				return "redirect:listeVoyage";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "la modification a échoué");
				return "redirect:modifVoyage";
			}
			
			
		}
		
		// ===================== fonctionnalité supprimer voyage
		@RequestMapping(value = "/voyageSupprimer", method = RequestMethod.GET)
		public String deleteVoyage(Model modele) {
			// lier un etudiant au model mvc afin de l'utiliser dans le
			modele.addAttribute("voySuppr", new Voyage());
			return "supprVoyage";
		}

		@RequestMapping(value = "/voyageSoumettreSupprimer", method = RequestMethod.POST)
		public String soumettreSuppr(@ModelAttribute("voySuppr") Voyage voyIn, RedirectAttributes ra) {
			try {
				voyageService.supprVoyageService(voyIn);;
				return "redirect:listeVoyager";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "la suppression a échoué");
				return "redirect:supprVoyage";
			}

		}
		
		// ===================== fonctionnalité rechercher voyage
		@RequestMapping(value = "/voyageRechercher", method = RequestMethod.GET)
		public String searchVoyage(Model modele) {
			// lier un etudiant au model mvc afin de l'utiliser dans le
			modele.addAttribute("voyRech", new Voyage());
			return "rechercheVoyage";
		}

		@RequestMapping(value = "/voyageSoumettreRecherche", method = RequestMethod.POST)
		public ModelAndView soumettreSearch(Model modele, @ModelAttribute("voyRech") Voyage voyIn, RedirectAttributes ra) {
			try {
				voyageService.getVoyageByIdService(voyIn.getId());
				return new ModelAndView("rechercheVoyage","voyRech",voyageService.getVoyageByIdService(voyIn.getId()));
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "la suppression a échoué");
				return new ModelAndView("redirect:rechercheVoyage");
			}
		}
		
		@RequestMapping(value = "/voyageSoumettre-supprLien", method = RequestMethod.GET)
		public String suppLien(@RequestParam("pId") int id) {
			voyageService.supprVoyageByIdService(id);;
			return "redirect:voyageListe";
		}

		@RequestMapping(value = "/soumettre-modifLien", method = RequestMethod.GET)
		public String modifLien(Model modele, @RequestParam("pId") int id) {
			Voyage voyOut = voyageService.getVoyageByIdService(id);
			modele.addAttribute("voyModif", voyOut);
			return "modifVoyage";
		}

}
