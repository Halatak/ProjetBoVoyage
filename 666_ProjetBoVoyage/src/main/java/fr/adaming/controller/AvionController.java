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

import fr.adaming.model.Avion;
import fr.adaming.service.IAvionService;

@Controller
@RequestMapping("/avion")
@Scope("session")
public class AvionController {

	@Autowired
	private IAvionService avService;

	/*
	 * @PostConstruct public void init() { // Recup le context de spring sécu
	 * Authentication
	 * authCxt=SecurityContextHolder.getContext().getAuthentication(); // Récup
	 * le mail à partir du context String mail=authCxt.getName();
	 * this.formateur=fService.getFormateurByMail(mail);
	 * 
	 * }
	 */

	// Liste Avion
	@RequestMapping(value = "/avionListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("listeAvion", "avionListe", avService.afficherListeAvionService());
	}

	// Fonctionnalité ajouter
	@RequestMapping(value = "/avionAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("avAjout", new Avion());
		return "ajouterAvion";
	}

	@RequestMapping(value = "/avionSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjout(ModelMap modele, @ModelAttribute("avAjout") Avion aIn, RedirectAttributes ra) {
		// Appel de la méthode service
		Avion aOut = avService.ajoutAvionService(aIn);
		if (aOut.getIdAvion() != 0) {
			return "redirect:listeAvion";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:avionAfficheAjout";
		}
	}

	// Modification
	@RequestMapping(value = "/avionAfficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("avModif", new Avion());

		return "modifierAvion";
	}

	@RequestMapping(value = "/avionSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(ModelMap modele, @ModelAttribute("avModif") Avion aIn, RedirectAttributes ra) {
		// Appel de la méthode service
		try {
			avService.modifierAvionService(aIn);
			return "redirect:listeAvion";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "modif a échoué");
			return "redirect:avionAfficheModifier";
		}

	}

	// Suppression
	@RequestMapping(value = "/avionAfficheSupprimer", method = RequestMethod.GET)
	public String afficheSuppr(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("avSuppr", new Avion());

		return "supprimerAvion";
	}

	@RequestMapping(value = "/avionSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(ModelMap modele, @ModelAttribute("avSuppr") Avion aIn, RedirectAttributes ra) {
		// Appel de la méthode service
		try {
			avService.supprAvionService(aIn);
			return "redirect:listeAvion";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "suppr a échoué");
			return "redirect:avionAfficheSupprimer";
		}

	}

	// Rechercher
	@RequestMapping(value = "/avionAfficheRechercher", method = RequestMethod.GET)
	public String afficheSearch(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("avSearch", new Avion());

		return "rechercheAvion";
	}

	// Rechercher
	@RequestMapping(value = "/soumettreSearch", method = RequestMethod.POST)
	public ModelAndView soumettreSearch(@ModelAttribute("avSearch") Avion aIn, RedirectAttributes ra) {
		// Appel de la méthode service

		Avion avOut = avService.getAvionByIdService(aIn.getIdAvion());
		if (avOut != null) {
			return new ModelAndView("rechercheAvion", "avion", avOut);
		} else {
			ra.addFlashAttribute("msg", "recherche a échoué");
			return new ModelAndView("redirect:avionAfficheRechercher");
		}

	}

	@RequestMapping(value = "/avionSoumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		avService.supprAvionByIdService(id);
		return "redirect:avionListe";
	}

	@RequestMapping(value = "/avionSoumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Avion avOut = avService.getAvionByIdService(id);
		modele.addAttribute("avModif", avOut);
		return "modifierAvion";
	}

}
