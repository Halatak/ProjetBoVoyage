package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hotel;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/hotel")
@Scope("session")
public class HotelController {

	// transformation de l'association UML en java
	@Autowired
	private IHotelService hService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// l'objet webdataBinder sert à faire le lien entre les params de la
		// requete et les objets java

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // permet de passer
															// du format string
															// au format date

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// Fonction afficher liste
	@RequestMapping(value = "/hotelListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {

		return new ModelAndView("listeHotel", "hotelListe", hService.afficherListeHotelService());
	}

	// fonction ajouter hotel
	@RequestMapping(value = "/hotelAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		modele.addAttribute("hoAjout", new Hotel());
		return "ajouterHotel";
	}

	@RequestMapping(value = "/hotelSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjout(ModelMap modele, @ModelAttribute("hoAjout") Hotel hIn, RedirectAttributes ra) {

		// appel de la methode service
		Hotel hOut = hService.ajoutHotelService(hIn);
		if (hOut.getId() != 0) {
			return "redirect:hotelListe";
		} else {
			ra.addFlashAttribute("msg", "L'ajout à échoué");
			return "redirect:hotelAfficheAjout";
		}
	}

	// Modification
	@RequestMapping(value = "/hotelAfficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model model) {
		// lier un hotel au modèle MVC
		model.addAttribute("hoModif", new Hotel());
		return "modifierHotel";
	}

	@RequestMapping(value = "/hotelSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(ModelMap modele, @ModelAttribute("hoModif") Hotel hIn, RedirectAttributes ra) {
		// appel de la méthode service
		try {
			hService.modifierHotelService(hIn);
			return "redirect:hotelListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "La modification a échouée");
			return "redirect:hotelAfficheModifier";
		}
	}

	// Suppression
	@RequestMapping(value = "/hotelAfficheSupprimer", method = RequestMethod.GET)
	public String afficheSuppr(Model modele) {
		// lier un hotel au modèle MVC
		modele.addAttribute("hoSuppr", new Hotel());
		return "supprimerHotel";
	}

	@RequestMapping(value = "/hotelSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(ModelMap modele, @ModelAttribute("hoSuppr") Hotel hIn, RedirectAttributes ra) {
		// appel de la methode service
		try {
			hService.supprHotelService(hIn);
			return "redirect:hotelListe";
		} catch (Exception e) {
			ra.addAttribute("msg", "La suppression a échouée");
			return "redirect:hotelAfficheSupprimer";
		}
	}

	// rechercher
	@RequestMapping(value = "/hotelAfficheRechercher", method = RequestMethod.GET)
	public String afficheSearch(Model modele) {

		// lier un hotel au modèle MVC
		modele.addAttribute("hoRechercher", new Hotel());
		return "rechercheHotel";
	}

	@RequestMapping(value = "/soumettreRechercher", method = RequestMethod.POST)
	public ModelAndView soumettreRecherche(@ModelAttribute("hoRecher") Hotel hIn, RedirectAttributes ra) {
		// appel de la methode service
		Hotel hOut = hService.getHotelByIdService(hIn.getId());
		if (hOut != null) {
			return new ModelAndView("rechercheHotel", "hotel", hOut);
		} else {
			ra.addFlashAttribute("msg", "La recherce à échouée");
			return new ModelAndView("redirect:hotelAfficheRerchercher");
		}
	}

	// les boutons
	@RequestMapping(value = "/hotelSoumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		hService.supprHotelByIdService(id);
		return "redirect:hotelListe";
	}

	@RequestMapping(value = "/hotelSoumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Hotel hOut = hService.getHotelByIdService(id);
		modele.addAttribute("hoModif", hOut);
		return "modifierHotel";
	}

}
