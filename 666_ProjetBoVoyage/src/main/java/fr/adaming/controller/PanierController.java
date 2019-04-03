package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Adresse;
import fr.adaming.model.Assurance;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Client;
import fr.adaming.model.Dossier;
import fr.adaming.model.Formule;
import fr.adaming.model.NombreCopain;
import fr.adaming.model.Panier;
import fr.adaming.model.SendMailSSL;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAccompagnantService;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.ICarteBancaireService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IPDFService;
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
	@Autowired
	private ICarteBancaireService CBService;
	@Autowired
	private IFormuleService fService;
	@Autowired
	private IAssuranceService aService;
	@Autowired
	private IAccompagnantService accService;
	@Autowired
	private IPDFService pdfService;

	private Client client;
	private Client client2;
	private int copInt;
	private int copInt2;
	private List<Accompagnant> listeAcc;
	private List<Formule> listeFormule;
	private static int numero;
	private double prixTotal = 0;

	public static int getNumero() {
		return numero;
	}

	@PostConstruct // initialise les conseillers
	public void init() {
		// recuperer le context de spring security
		Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

		// recuperer le mail à partir du context
		String mail = authCxt.getName();
		this.client = clientService.getClientByMail(mail);
		client2 = client;

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
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		panier.setDossier(dossier);
		Voyage voyIn = voyageService.getVoyageByIdService(id);
		panier.getDossier().setVoyage(voyIn);

		// lier un etudiant au model mvc afin de l'utiliser dans le formulaire

		// if (panier != null) {
		// return "redirect:panierAfficheAssurance";

		return "redirect:panierAfficheFormule";
		// } else {
		// ra.addFlashAttribute("msg", "l'ajout a échoué");
		// return "redirect:accueil";
		// }
	}

	// Lier une assurance au panier
	@RequestMapping(value = "/panierAfficheFormule", method = RequestMethod.GET)
	public String afficheAjoutFormule(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}

		if (client2 != null) {
			modele.addAttribute("client", client2);
			modele.addAttribute("foAjout", fService.getFormuleByVoyage(panier.getDossier().getVoyage().getId()));
			return "choixFormuleClient";

		} else {
			modele.addAttribute("foAjout", fService.getFormuleByVoyage(panier.getDossier().getVoyage().getId()));
			return "choixFormule";
		}

	}

	@RequestMapping(value = "/panierSoumettreFormule", method = RequestMethod.GET)
	public String soumettreAjoutFormule(ModelMap modele, @RequestParam("pId") int id, RedirectAttributes ra) {
		// Appel de la méthode service
		if (listeFormule == null) {
			listeFormule = new ArrayList<>();
		}
		listeFormule.add(fService.getFormuleByIdService(id));
		panier.getDossier().getVoyage().setListeFormule(listeFormule);
		if (panier.getDossier().getVoyage().getListeFormule() != null) {
			return "redirect:panierAfficheAssurance";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return "redirect:/voyage/listeVoyage";
		}
	}

	// Lier une assurance au panier
	@RequestMapping(value = "/panierAfficheAssurance", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (client2 != null) {
			modele.addAttribute("client", client2);
			modele.addAttribute("asAjout", new Assurance());
			return "choixAssuranceClient";

		} else {
			modele.addAttribute("asAjout", new Assurance());
			return "choixAssurance";
		}

	}

	@RequestMapping(value = "/panierSoumettreAssurance", method = RequestMethod.POST)
	public String soumettreAjout(ModelMap modele, @ModelAttribute("asAjout") Assurance aIn, RedirectAttributes ra) {
		// recupere l'assurance
		Assurance aOut = aService.getAssuranceByIdService(aIn.getId());
		// Appel de la méthode service
		panier.getDossier().setAssurance(aOut);

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
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (client2 != null) {
			modele.addAttribute("client", client2);
			if (client != null) {
				modele.addAttribute("cliAjout", client);
				return "choixClientClient";
			} else {
				modele.addAttribute("cliAjout", new Client());
				return "choixClientClient";
			}

		} else {
			if (client != null) {
				modele.addAttribute("cliAjout", client);
				return "choixClient";
			} else {
				modele.addAttribute("cliAjout", new Client());
				return "choixClient";
			}
		}

	}

	@RequestMapping(value = "/panierSoumettreClient", method = RequestMethod.POST)
	public String soumettreAjoutClient(ModelMap modele, @ModelAttribute("cliAjout") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		String mailTest = null;
		Client clicli = new Client();
		try {
			mailTest = clientService.getClientByMail(cIn.getMail()).getMail();
			clicli = clientService.getClientByMail(mailTest);

		} catch (Exception e) {

		}

		if (dossierService.getDossierByIdClientDao(client) == null
				&& dossierService.getDossierByIdClientDao(clientService.getClientByMail(cIn.getMail())) == null) {
			if (client != null && client.getMail().equals(cIn.getMail())) {
				cIn.setIdCl(client.getIdCl());
				cIn.setActive(true);
				cIn.setMdp(client.getMdp());
				cIn.setAdresse(client.getAdresse());
				cIn.setCarteBancaire(client.getCarteBancaire());
				clientService.modifierClientService(cIn);
				client = cIn;
				panier.getDossier().setClient(cIn);
			} else if (client == null && cIn.getMail().equals(mailTest)) {
				cIn.setIdCl(clicli.getIdCl());
				cIn.setAdresse(clicli.getAdresse());
				cIn.setCarteBancaire(clicli.getCarteBancaire());
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
			ra.addFlashAttribute("msg", "Vous avez déjà commandé un voyage, impossible d'en commander un second !");
			return "redirect:/voyage/voyageListe";
		}

	}

	@RequestMapping(value = "/panierAfficheAdresse", method = RequestMethod.GET)
	public String afficheAjoutAdresse(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (client2 != null) {
			modele.addAttribute("cliAjout", client2);
			try {
				modele.addAttribute("addAjout", client.getAdresse());
				return "choixAdresseClient";

			} catch (Exception e) {
				modele.addAttribute("addAjout", new Adresse());
				return "choixAdresseClient";
			}
		} else {
			try {
				modele.addAttribute("addAjout", client.getAdresse());
				return "choixAdresse";

			} catch (Exception e) {
				modele.addAttribute("addAjout", new Adresse());
				return "choixAdresse";
			}
		}
	}

	@RequestMapping(value = "/panierSoumettreAdresse", method = RequestMethod.POST)
	public String soumettreAjoutAdresse(ModelMap modele, @ModelAttribute("addAjout") Adresse addIn,
			RedirectAttributes ra) {
		// Appel de la méthode service
		panier.getDossier().getClient().setAdresse(addIn);
		clientService.modifierClientService(panier.getDossier().getClient());

		if (panier.getDossier().getClient().getAdresse() != null) {
			return "redirect:panierAfficheNombreCopain";
		} else {
			ra.addFlashAttribute("msg", "l'ajout d'adresse a échoué");
			return "redirect:panierAfficheAdresse";
		}
	}

	@RequestMapping(value = "/panierAfficheNombreCopain", method = RequestMethod.GET)
	public String afficheAjoutNBCopain(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (client2 != null) {
			modele.addAttribute("cliAjout", client2);
			modele.addAttribute("copInt", new NombreCopain());
			return "choixNBCopainClient";
		} else {
			modele.addAttribute("copInt", new NombreCopain());
			return "choixNBCopain";
		}
	}

	@RequestMapping(value = "/panierSoumettreNombreCopain", method = RequestMethod.POST)
	public String soumettreAjoutCopainNB(ModelMap modele, @ModelAttribute("copInt") NombreCopain coIn,
			RedirectAttributes ra) {
		// Appel de la méthode service
		copInt = coIn.getNbCop();
		copInt2 = copInt;
		return "redirect:panierAfficheCopain";
	}

	@RequestMapping(value = "/panierAfficheCopain", method = RequestMethod.GET)
	public String afficheAjoutCopain(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		if (copInt > 0) {
			try {
				Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

				// recuperer le mail à partir du context
				String mail = authCxt.getName();
				client2 = clientService.getClientByMail(mail);
				client = client2;
			} catch (Exception e) {

			}
			if (client2 != null) {
				modele.addAttribute("cliAjout", client2);
				modele.addAttribute("copain", new Accompagnant());
				return "choixCopainClient";
			} else {
				modele.addAttribute("copain", new Accompagnant());
				return "choixCopain";
			}
		} else {
			return "redirect:panierAfficheRecapitulatif";
		}
	}

	@RequestMapping(value = "/panierSoumettreCopain", method = RequestMethod.POST)
	public String soumettreAjoutCopain(ModelMap modele, @ModelAttribute("copain") Accompagnant accIn,
			RedirectAttributes ra) {
		// Appel de la méthode service
		if (copInt > 0) {
			if (listeAcc == null) {
				listeAcc = new ArrayList<>();
			}
			accIn.setClient(panier.getDossier().getClient());
			listeAcc.add(accIn);
			panier.getDossier().getClient().setListeAccompagnant(listeAcc);
			accService.ajoutAccompagnantService(accIn);
			copInt--;

			if (copInt > 0) {
				return "redirect:panierAfficheCopain";
			} else {
				return "redirect:panierAfficheRecapitulatif";
			}
		} else {
			return "redirect:panierAfficheRecapitulatif";
		}
	}

	@RequestMapping(value = "/panierAfficheRecapitulatif", method = RequestMethod.GET)
	public String afficheAjoutRecapitulatif(Model modele) {
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (panier.getDossier().getVoyage().getListeFormule().get(0).getAvion() != null
				&& panier.getDossier().getVoyage().getListeFormule().get(0).getHotel() != null
				&& panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getAvion().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getHotel().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getAvion() != null
				&& panier.getDossier().getVoyage().getListeFormule().get(0).getHotel() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getAvion().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getHotel().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getAvion() != null
				&& panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getAvion().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getHotel() != null
				&& panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getHotel().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getAvion() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getAvion().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getHotel() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getHotel().getPrix());
		} else if (panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture() != null) {
			prixTotal = (1 + copInt2)
					* (panier.getDossier().getVoyage().getPrix() + panier.getDossier().getAssurance().getPrix()
							+ panier.getDossier().getVoyage().getListeFormule().get(0).getVoiture().getPrix());
		}

		panier.getDossier().getVoyage().setPrix(prixTotal);

		if (client2 != null) {

			modele.addAttribute("client", client2);
			modele.addAttribute("voyage", panier.getDossier().getVoyage());
			modele.addAttribute("dossier", panier.getDossier());
			modele.addAttribute("formule", panier.getDossier().getVoyage().getListeFormule().get(0));

			return "recapPanierClient";

		} else {
			modele.addAttribute("voyage", panier.getDossier().getVoyage());
			modele.addAttribute("dossier", panier.getDossier());
			modele.addAttribute("formule", panier.getDossier().getVoyage().getListeFormule().get(0));
			return "recapPanier";
		}

	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouter", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanier(RedirectAttributes ra) {
		if (dossierService.getDossierByIdClientDao(panier.getDossier().getClient()) == null) {
			panier.getDossier().setEtat("enAttente");
			panier.getDossier().setNumero(
					1 + 111 * clientService.getClientByMail(panier.getDossier().getClient().getMail()).getIdCl());

			dossierService.ajoutDossierService(panier.getDossier());
			String message = "Bonjour " + panier.getDossier().getClient().getCivilite() + " "
					+ panier.getDossier().getClient().getNom() + " " + panier.getDossier().getClient().getPrenom()
					+ "\n Nous vous informons que votre voyage a bien été réservé, nous allons vous mettre en relation avec un conseiller pour vous aider. "
					+ "\n A bientot !";

			// On "test" l'envoi du mail
			try {
				// création du pdf
				pdfService.creerPDF(panier.getDossier(), panier.getDossier().getClient(), numero);
				SendMailSSL sm = new SendMailSSL();
				sm.sendMailDeux(panier.getDossier().getClient().getMail(), message);
				numero++;
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "Mail non joint");
			}
			panier.getDossier().getVoyage().setNbPlaces(panier.getDossier().getVoyage().getNbPlaces() - 1 - copInt2);
			voyageService.modifierVoyageService(panier.getDossier().getVoyage());
			return new ModelAndView("redirect:/paypal");

		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return new ModelAndView("redirect:/voyage/voyageListe");
		}
	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouterSansPayer", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanierSansPayer(RedirectAttributes ra) {
		if (dossierService.getDossierByIdClientDao(panier.getDossier().getClient()) == null) {
			panier.getDossier().setEtat("enAttente");
			panier.getDossier().setNumero(
					1 + 111 * clientService.getClientByMail(panier.getDossier().getClient().getMail()).getIdCl());

			dossierService.ajoutDossierService(panier.getDossier());
			String message = "Bonjour " + panier.getDossier().getClient().getCivilite() + " "
					+ panier.getDossier().getClient().getNom() + " " + panier.getDossier().getClient().getPrenom()
					+ "\n Nous vous informons que votre voyage a bien été réservé, nous allons vous mettre en relation avec un conseiller pour vous aider. "
					+ "\n A bientot !";

			// On "test" l'envoi du mail
			try {
				// création du pdf
				pdfService.creerPDF(panier.getDossier(), panier.getDossier().getClient(), numero);
				SendMailSSL sm = new SendMailSSL();
				sm.sendMailDeux(panier.getDossier().getClient().getMail(), message);
				numero++;
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "Mail non joint");
			}
			panier.getDossier().getVoyage().setNbPlaces(panier.getDossier().getVoyage().getNbPlaces() - 1 - copInt2);
			voyageService.modifierVoyageService(panier.getDossier().getVoyage());
			return new ModelAndView("redirect:/voyage/voyageListe");
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return new ModelAndView("redirect:/voyage/voyageListe");
		}

	}

	@RequestMapping(value = "/dossierPanierSoumettreAjouterPayerCB", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutDossierPanierPayerCB(RedirectAttributes ra) {
		if (dossierService.getDossierByIdClientDao(panier.getDossier().getClient()) == null) {
			panier.getDossier().setEtat("enAttente");
			panier.getDossier().setNumero(
					111 * clientService.getClientByMail(panier.getDossier().getClient().getMail()).getIdCl() + 1);

			dossierService.ajoutDossierService(panier.getDossier());
			String message = "Bonjour " + panier.getDossier().getClient().getCivilite() + " "
					+ panier.getDossier().getClient().getNom() + " " + panier.getDossier().getClient().getPrenom()
					+ "\n Nous vous informons que votre voyage a bien été réservé, nous allons vous mettre en relation avec un conseiller pour vous aider. "
					+ "\n A bientot !";

			// On "test" l'envoi du mail
			try {
				// création du pdf
				pdfService.creerPDF(panier.getDossier(), panier.getDossier().getClient(), numero);
				SendMailSSL sm = new SendMailSSL();
				sm.sendMailDeux(panier.getDossier().getClient().getMail(), message);
				numero++;
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "Mail non joint");
			}
			panier.getDossier().getVoyage().setNbPlaces(panier.getDossier().getVoyage().getNbPlaces() - 1 - copInt2);
			voyageService.modifierVoyageService(panier.getDossier().getVoyage());
			return new ModelAndView("redirect:/panier/panierAfficherCB");
		} else {
			ra.addFlashAttribute("msg", "l'ajout a échoué");
			return new ModelAndView("redirect:/voyage/voyageListe");
		}

	}

	@RequestMapping(value = "/panierAfficherCB", method = RequestMethod.GET)
	public String afficheAjoutCB(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		try {
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

			// recuperer le mail à partir du context
			String mail = authCxt.getName();
			client2 = clientService.getClientByMail(mail);
			client = client2;
		} catch (Exception e) {

		}
		if (client2 != null) {
			modele.addAttribute("client", client2);

			if (client.getCarteBancaire() != null) {
				modele.addAttribute("CBAjout", client.getCarteBancaire());
				return "choixCBClient";

			} else {
				modele.addAttribute("CBAjout", new CarteBancaire());
				return "choixCBClient";
			}

		} else {
			if (client.getCarteBancaire() != null) {
				modele.addAttribute("CBAjout", client.getCarteBancaire());
				return "choixCB";

			} else {
				modele.addAttribute("CBAjout", new CarteBancaire());
				return "choixCB";
			}
		}

	}

	@RequestMapping(value = "/panierSoumettreCB", method = RequestMethod.POST)
	public String soumettreAjoutCB(ModelMap modele, @ModelAttribute("CBAjout") CarteBancaire cbIn,
			RedirectAttributes ra) {

		// Appel de la méthode service

		if (CBService.getCBByClient(panier.getDossier().getClient()) != null) {
			cbIn.setClient(panier.getDossier().getClient());
			cbIn.setIdCarte(CBService.getCBByClient(panier.getDossier().getClient()).getIdCarte());
			CBService.modifierCarteBancaireService(cbIn);
			panier.getDossier().getClient().setCarteBancaire(cbIn);
		} else {
			cbIn.setClient(panier.getDossier().getClient());
			CBService.ajoutCarteBancaireService(cbIn);
			panier.getDossier().getClient().setCarteBancaire(cbIn);
		}
		if (panier.getDossier().getClient().getCarteBancaire() != null) {
			return "redirect:/voyage/voyageListe";
		} else {
			ra.addFlashAttribute("msg", "l'ajout de CB a échoué");
			return "redirect:panierAfficherCB";
		}
	}

}