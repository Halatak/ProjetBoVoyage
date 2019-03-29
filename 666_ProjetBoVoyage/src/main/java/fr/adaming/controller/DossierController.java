package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Dossier;
import fr.adaming.model.Panier;
import fr.adaming.model.Voyage;
import fr.adaming.service.IDossierService;

@Controller
@RequestMapping("/dossier")
@Scope("session")
public class DossierController {

	@Autowired
	private IDossierService dossierService;

	// page d'accueil qui affiche la liste des dossiers
	@RequestMapping(value = "/dossierListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("accueilConseillerClientele", "dossierListe",
				dossierService.afficherListeDossierService());
	}

	// ===================== fonctionnalité ajouter dossier
	@RequestMapping(value = "/dossierAjouter", method = RequestMethod.GET)
	public String addDossier(Model modele) {
		modele.addAttribute("doAjout", new Dossier());
		return "ajoutDossier";
	}

	@RequestMapping(value = "/dossierSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjout(@ModelAttribute("doAjout") Dossier doIn, RedirectAttributes ra) {
		doIn.setEtat("enAttente");

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire

		Dossier doOut = dossierService.ajoutDossierService(doIn);

		if (doOut.getId() != 0) {
			return "redirect:accueil";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:dossierAjouter";
		}

	}

	// ===================== fonctionnalité modifier dossier
	@RequestMapping(value = "/dossierModifier", method = RequestMethod.GET)
	public String updateDossier(Model modele) {

		// lier un etudiant au model mvc afin de l'utiliser dans le
		modele.addAttribute("doModif", new Dossier());
		return "modifDossier";
	}

	@RequestMapping(value = "/dossierSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(@ModelAttribute("doModif") Dossier doIn, RedirectAttributes ra) {
		Dossier doOut = null;
		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire

		try {
			dossierService.modifierDossierService(doIn);
			return "redirect:dossierListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:dossierAjouter";
		}

	}

	// ===================== fonctionnalité supprimer dossier
	@RequestMapping(value = "/dossierSupprimer", method = RequestMethod.GET)
	public String deleteDossier(Model modele) {
		// lier un etudiant au model mvc afin de l'utiliser dans le
		modele.addAttribute("doSuppr", new Dossier());
		return "SupprDossier";
	}

	@RequestMapping(value = "/dossierSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(@ModelAttribute("doSuppr") Dossier doIn, RedirectAttributes ra) {
		try {
			dossierService.supprDossierService(doIn);
			return "redirect:dossierListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "la suppression a échoué");
			return "redirect:dossierSupprimer";
		}

	}

	// ===================== fonctionnalité rechercher dossier
	@RequestMapping(value = "/dossierRechercher", method = RequestMethod.GET)
	public String searchDossier(Model modele) {
		// lier un etudiant au model mvc afin de l'utiliser dans le
		modele.addAttribute("doRech", new Dossier());
		return "rechercheDossier";
	}

	@RequestMapping(value = "/dossierSoumettreRecherche", method = RequestMethod.POST)
	public ModelAndView soumettreSearch(Model modele, @ModelAttribute("doRech") Dossier doIn, RedirectAttributes ra) {
		try {
			dossierService.getDossierByIdService(doIn.getId());
			return new ModelAndView("rechercheDossier", "doRech", dossierService.getDossierByIdService(doIn.getId()));
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "la suppression a échoué");
			return new ModelAndView("redirect:rechercheDossier");
		}
	}

	@RequestMapping(value = "/soumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		dossierService.supprDossierByIdService(id);
		return "redirect:dossierListe";
	}

	@RequestMapping(value = "/soumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Dossier doOut = dossierService.getDossierByIdService(id);
		modele.addAttribute("doModif", doOut);
		return "modifDossier";
	}

}
