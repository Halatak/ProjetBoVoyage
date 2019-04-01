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

import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerClientService;
import fr.adaming.service.IConseillerMarketingService;
import fr.adaming.service.IDestinationService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/voyage")
@Scope("session")
public class VoyageController {

	// transformation assoc uml en java
	@Autowired
	private IVoyageService voyageService;
	@Autowired
	private IDestinationService destinationService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private IConseillerClientService conClientService;
	@Autowired
	private IConseillerMarketingService conMarketService;

	// Methode pour convertir et afficher correctement les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// l'objet WebDataBinder sert à faire le lien entre les params de la
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);

		// la methode registerCustomEditor: à configurer la conversion du param
		// recu au type de l'attribut

		// l'objet CustomDateEditor: sert à lier la date recue comme params de
		// la requete à l'attribut de l'objet etudiant

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// page d'accueil qui affiche la liste des voyages
	@RequestMapping(value = "/voyageListe", method = RequestMethod.GET)
	public ModelAndView afficheListe(Model modele) {
		modele.addAllAttributes(conMarketService.afficherListeConseillerMarkService());
		modele.addAllAttributes(conClientService.afficherListeConseillerClientService());
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

		Voyage voyOut = null;

		String voyInDepartHeure = voyIn.getHeureDepart().substring(0, 2);
		String voyInDepartMinute = voyIn.getHeureDepart().substring(3, 5);
		String voyInArriveHeure = voyIn.getHeureArrive().substring(0, 2);
		String voyInArriveMinute = voyIn.getHeureArrive().substring(3, 5);

		voyIn.getDateDepart().setHours(Integer.parseInt(voyInDepartHeure));
		voyIn.getDateDepart().setMinutes(Integer.parseInt(voyInDepartMinute));
		voyIn.getDateArrivee().setHours(Integer.parseInt(voyInArriveHeure));
		voyIn.getDateArrivee().setMinutes(Integer.parseInt(voyInArriveMinute));

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		if (voyIn.getDestination().getIdDestination() != 0) {

			Destination deIn = destinationService.getDestinationByIdService(voyIn.getDestination().getIdDestination());

			if (deIn != null) {
				voyIn.setDestination(deIn);
			} else {
				ra.addFlashAttribute("msg",
						"la destination est invalide, entrez une destination valide ou 0 pour dire qu'il n'y a pas de destination");
				return "redirect:voyageAjouter";
			}

		} else {
			voyIn.setDestination(null);

		}

		voyOut = voyageService.ajoutVoyageService(voyIn);
		if (voyOut.getId() != 0) {
			return "redirect:voyageListe";
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
		Voyage voyOut = null;
		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		if (voyIn.getDestination().getIdDestination() != 0) {

			Destination deIn = destinationService.getDestinationByIdService(voyIn.getDestination().getIdDestination());

			if (deIn != null) {
				voyIn.setDestination(deIn);
			} else {
				ra.addFlashAttribute("msg",
						"la destination est invalide, entrez une destination valide ou 0 pour dire qu'il n'y a pas de destination");
				return "redirect:voyageModifier";
			}

		} else {
			voyIn.setDestination(null);

		}
		try {
			voyageService.modifierVoyageService(voyIn);
			return "redirect:voyageListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:voyageAjouter";
		}

	}

	// ===================== fonctionnalité supprimer voyage
	@RequestMapping(value = "/voyageSupprimer", method = RequestMethod.GET)
	public String deleteVoyage(Model modele) {
		// lier un etudiant au model mvc afin de l'utiliser dans le
		modele.addAttribute("voySuppr", new Voyage());
		return "SupprVoyage";
	}

	@RequestMapping(value = "/voyageSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(@ModelAttribute("voySuppr") Voyage voyIn, RedirectAttributes ra) {
		try {
			voyageService.supprVoyageService(voyIn);
			return "redirect:voyageListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "la suppression a échoué");
			return "redirect:voyageSupprimer";
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
			return new ModelAndView("rechercheVoyage", "voyRech", voyageService.getVoyageByIdService(voyIn.getId()));
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "la suppression a échoué");
			return new ModelAndView("redirect:rechercheVoyage");
		}
	}

	@RequestMapping(value = "/soumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		voyageService.supprVoyageByIdService(id);
		return "redirect:voyageListe";
	}

	@RequestMapping(value = "/soumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Voyage voyOut = voyageService.getVoyageByIdService(id);
		modele.addAttribute("voyModif", voyOut);
		return "modifVoyage";
	}

}
