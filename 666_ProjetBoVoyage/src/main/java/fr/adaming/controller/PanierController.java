package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import fr.adaming.model.Adresse;
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

		// recuperer le mail à partir du context
		String mail = authCxt.getName();
		this.client = clientService.getClientByMail(mail);

	}

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
		// ra.addFlashAttribute("msg", "l'ajout a échoué");
		// return "redirect:accueil";
		// }
	}

	// Lier une assurance au panier
	@RequestMapping(value = "/panierAfficheAssurance", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("asAjout", new Assurance());
		return "choixAssurance";
	}

	@RequestMapping(value = "/panierSoumettreAssurance", method = RequestMethod.POST)
	public String soumettreAjout(ModelMap modele, @ModelAttribute("asAjout") Assurance aIn, RedirectAttributes ra) {
		// Appel de la méthode service
		panier.getDossier().setAssurance(aIn);

		if (panier.getDossier().getAssurance() != null) {
			return "redirect:panierAfficheClient";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:panierAfficheAssurance";
		}
	}

	// Lier un client au panier
	@RequestMapping(value = "/panierAfficheClient", method = RequestMethod.GET)
	public String afficheAjoutClient(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
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
		// Appel de la méthode service
		System.out.println("dada");
		if (dossierService.getDossierByIdClientDao(client) == null) {
			if (client != null && client.getMail().equals(cIn.getMail())) {
				cIn.setIdCl(client.getIdCl());
				cIn.setActive(true);
				cIn.setMdp(client.getMdp());
				cIn.setAdresse(client.getAdresse());
				cIn.setCarteBancaire(client.getCarteBancaire());
				clientService.modifierClientService(cIn);
				client = cIn;
				panier.getDossier().setClient(cIn);
			} else if (client == null) {
				cIn = clientService.ajoutClientService(cIn);
				panier.getDossier().setClient(cIn);
			}
		}

		if (panier.getDossier().getClient() != null) {
			return "redirect:panierAfficheAdresse";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:panierAfficheClient";
		}

		/*
		 * if (panier.getDossier().getClient() != null) { return
		 * "redirect:dossierPanierSoumettreAjouter"; } else {
		 * ra.addFlashAttribute("msg", "l'ajout a échoué"); return
		 * "redirect:panierAfficheClient"; }
		 */
	}

	@RequestMapping(value = "/panierAfficheAdresse", method = RequestMethod.GET)
	public String afficheAjoutAdresse(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		if (client.getAdresse() != null) {
			modele.addAttribute("addAjout", client.getAdresse());
			return "choixAdresse";
		} else {
			modele.addAttribute("addAjout", new Adresse());
			return "choixAdresse";
		}
	}

	@RequestMapping(value = "/panierSoumettreAdresse", method = RequestMethod.POST)
	public String soumettreAjoutAdresse(ModelMap modele, @ModelAttribute("addAjout") Adresse addIn,
			RedirectAttributes ra) {
		// Appel de la méthode service

		client.setAdresse(addIn);
		clientService.modifierClientService(client);
		panier.getDossier().setClient(client);

		if (panier.getDossier().getClient().getAdresse() != null) {
			return "redirect:panierAfficheRecapitulatif";
		} else {
			ra.addFlashAttribute("msg", "l'ajout d'adresse a échoué");
			return "redirect:panierAfficheAdresse";
		}

		/*
		 * if (panier.getDossier().getClient() != null) { return
		 * "redirect:dossierPanierSoumettreAjouter"; } else {
		 * ra.addFlashAttribute("msg", "l'ajout a échoué"); return
		 * "redirect:panierAfficheClient"; }
		 */
	}

	@RequestMapping(value = "/panierAfficheRecapitulatif", method = RequestMethod.GET)
	public String afficheAjoutRecapitulatif(Model modele) {
		modele.addAttribute("voyage", panier.getDossier().getVoyage());
		return "recapPanier";

	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouter", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanier(RedirectAttributes ra) {

		panier.getDossier().setEtat("enAttente");
		panier.getDossier().setNumero(111 * (client.getIdCl() + 1));

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		Dossier doOut = dossierService.ajoutDossierService(panier.getDossier());

		// if (doOut.getId() != 0) {
		return new ModelAndView("redirect:/paypal");
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a échoué");
		// return "redirect:dossierAjouter";
		// }

	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouterSansPayer", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanierSansPayer(RedirectAttributes ra) {

		panier.getDossier().setEtat("enAttente");
		panier.getDossier().setNumero(111 * (client.getIdCl() + 1));

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		Dossier doOut = dossierService.ajoutDossierService(panier.getDossier());

		// if (doOut.getId() != 0) {
		return new ModelAndView("redirect:/voyage/voyageListe");
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a échoué");
		// return "redirect:dossierAjouter";
		// }

	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouterPayerCB", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanierPayerCB(RedirectAttributes ra) {

		panier.getDossier().setEtat("enAttente");
		panier.getDossier().setNumero(111 * (client.getIdCl() + 1));

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire
		Dossier doOut = dossierService.ajoutDossierService(panier.getDossier());

		// if (doOut.getId() != 0) {
		return new ModelAndView("redirect:/panierAfficherCB");
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a échoué");
		// return "redirect:dossierAjouter";
		// }

	}
}
