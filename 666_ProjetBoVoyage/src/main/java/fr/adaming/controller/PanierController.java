package fr.adaming.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Assurance;
import fr.adaming.model.Client;
import fr.adaming.model.Dossier;
import fr.adaming.model.Panier;
import fr.adaming.model.Voyage;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/panier")
@Scope("session")
public class PanierController {
	Panier panier = new Panier();
	Dossier dossier = new Dossier();
	@Autowired
	private IVoyageService voyageService;
	@Autowired
	private IDossierService dossierService;
	@Autowired
	private IClientService clientService;
	private Client client;

	@PostConstruct // initialise les conseillers
	public void init() {
		// recuperer le context de spring security
		Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

		// recuperer le mail � partir du context
		String mail = authCxt.getName();
		this.client = clientService.getClientByMail(mail);

	}

	// Ajouter un voyage au panier
	@RequestMapping(value = "/panierSoumettreAjouter", method = RequestMethod.GET)
	public String soumettreAjoutPanier(@RequestParam("pId") int id, RedirectAttributes ra) {
		Voyage voyIn = voyageService.getVoyageByIdService(id);
		panier.setDossier(dossier);
		panier.getDossier().setVoyage(voyIn);

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire

		// if (panier != null) {
		return "redirect:panierAfficheAssurance";
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a �chou�");
		// return "redirect:accueil";
		// }
	}

	// Lier une assurance au panier
	@RequestMapping(value = "/panierAfficheAssurance", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("asAjout", new Assurance());
		return "choixAssurance";
	}

	@RequestMapping(value = "/panierSoumettreAssurance", method = RequestMethod.POST)
	public String soumettreAjout(ModelMap modele, @ModelAttribute("asAjout") Assurance aIn, RedirectAttributes ra) {
		// Appel de la m�thode service
		panier.getDossier().setAssurance(aIn);

		if (panier.getDossier().getAssurance() != null) {
			return "redirect:panierAfficheClient";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a �chou�");
			return "redirect:panierAfficheAssurance";
		}
	}

	// Lier un client au panier
	@RequestMapping(value = "/panierAfficheClient", method = RequestMethod.GET)
	public String afficheAjoutClient(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		if (client != null) {
			modele.addAttribute("cliAjout", client);
			return "choixClient";
		} else {
			modele.addAttribute("cliAjout", new Client());
			return "choixClient";
		}
	}

	@RequestMapping(value = "/panierSoumettreClient", method = RequestMethod.POST)
	public String soumettreAjoutClient(ModelMap modele, @ModelAttribute("cliAjout") Client cIn, RedirectAttributes ra) {
		// Appel de la m�thode service
		System.out.println(client);
		System.out.println(dossierService.getDossierByIdClientDao(client));
		if (dossierService.getDossierByIdClientDao(client) == null) {
			if (client != null && client.getMail() == cIn.getMail()) {
				clientService.modifierClientService(client);
				panier.getDossier().setClient(cIn);
			} else if (client == null) {
				cIn = clientService.ajoutClientService(cIn);
				panier.getDossier().setClient(cIn);
			}
		}

		if (panier.getDossier().getClient() != null) {
			return "redirect:dossierPanierSoumettreAjouter";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a �chou�");
			return "redirect:panierAfficheClient";
		}
	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouter", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanier(RedirectAttributes ra) {

		panier.getDossier().setEtat("enAttente");
		panier.getDossier().setNumero(111 * (panier.getDossier().getId() + 1));

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		Dossier doOut = dossierService.ajoutDossierService(panier.getDossier());

		// if (doOut.getId() != 0) {
		return new ModelAndView("redirect:/paypal");
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a �chou�");
		// return "redirect:dossierAjouter";
		// }

	}
}
