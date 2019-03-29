package fr.adaming.controller;

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

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
@Scope("session")
public class ClientController {

	private IClientService cService;

	// Liste Avion
	@RequestMapping(value = "/clientListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("listeClient", "clientListe", cService.afficherListeClientService());
	}

	// Fonctionnalité ajouter
	@RequestMapping(value = "/clientAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("clAjout", new Client());
		return "ajouterClient";
	}
	
	//commentaire
	@RequestMapping(value = "/clientSoumettreAjouter", method = RequestMethod.POST)
	public ModelAndView soumettreAjout(ModelMap modele, @ModelAttribute("clAjout") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		Client cOut = cService.ajoutClientService(cIn);
		if (cOut.getIdCl() != 0) {
			return new ModelAndView("ajouterCarteBancaire", "cOut",cService.afficherListeClientService());
		} else {
			ra.addFlashAttribute("msg", "L'ajout a échoué");
			return new ModelAndView("accueil");
		}
	}
	
	// Fonctionnalité ajouter carte bancaire
	@RequestMapping(value = "/clientAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjoutCB(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("cbAjout", new Client());
		return "ajouterClient";
	}

	@RequestMapping(value = "/clientSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjoutCB(ModelMap modele, @ModelAttribute("clAjout") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		Client cOut = cService.ajoutClientService(cIn);
		if (cOut.getIdCl() != 0) {
			return "redirect:clientListe";
		} else {
			ra.addFlashAttribute("msg", "L'ajout a échoué");
			return "redirect:clientAfficheAjout";
		}
	}

	// Modification
	@RequestMapping(value = "/clientAfficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("clModif", new Client());

		return "modifierClient";
	}

	@RequestMapping(value = "/clientSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(ModelMap modele, @ModelAttribute("clModif") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		try {
			cService.modifierClientService(cIn);;
			return "redirect:clientListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "La modification a échouée");
			return "redirect:clientAfficheModifier";
		}

	}

	// Suppression
	@RequestMapping(value = "/clientAfficheSupprimer", method = RequestMethod.GET)
	public String afficheSuppr(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("clSuppr", new Client());

		return "supprimerClient";
	}

	@RequestMapping(value = "/clientSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(ModelMap modele, @ModelAttribute("clSuppr") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		try {
			cService.supprClientService(cIn);;
			return "redirect:clientListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "La suppression a échouée");
			return "redirect:clientAfficheSupprimer";
		}

	}

	// Rechercher
	@RequestMapping(value = "/clientAfficheRechercher", method = RequestMethod.GET)
	public String afficheSearch(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("clRecher", new Client());

		return "rechercheClient";
	}

	// Rechercher
	@RequestMapping(value = "/soumettreSearch", method = RequestMethod.POST)
	public ModelAndView soumettreSearch(@ModelAttribute("clRecher") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service

		Client cOut = cService.getClientByIdService(cIn.getIdCl());
		if (cOut != null) {
			return new ModelAndView("rechercheClient", "client", cOut);
		} else {
			ra.addFlashAttribute("msg", "La recherche a échouée");
			return new ModelAndView("redirect:clientAfficheRechercher");
		}

	}

	@RequestMapping(value = "/clientSoumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		cService.supprClientByIdService(id);;
		return "redirect:clientListe";
	}

	@RequestMapping(value = "/clientSoumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Client cOut = cService.getClientByIdService(id);
		modele.addAttribute("clModif", cOut);
		return "modifierClient";
	}
}
