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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.ConseillerMarketing;
import fr.adaming.model.Role;
import fr.adaming.model.SendMailSSL;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerClientService;
import fr.adaming.service.IConseillerMarketingService;
import fr.adaming.service.IRoleService;

@Controller
@RequestMapping("/choixLogin")
@Scope("session")
public class ChoixLoginController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private IConseillerClientService conClientService;
	@Autowired
	private IConseillerMarketingService conMarketService;
	private ConseillerClientele conseillerClientele = new ConseillerClientele();
	private ConseillerMarketing conseillerMarketing = new ConseillerMarketing();
	private Client client;

	@PostConstruct // initialise les conseillers
	public void init() {
		// recuperer le context de spring security
		Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

		// recuperer le mail à partir du context
		String mail = authCxt.getName();
		conseillerClientele = conClientService.getConsClientByMail(mail);
		conseillerMarketing = conMarketService.getConseillerMarkByMail(mail);
		client = clientService.getClientByMail(mail);
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

	@RequestMapping(value = "/choix", method = RequestMethod.GET)
	public ModelAndView afficheConseillerMarketing(RedirectAttributes ra) {

		if (conseillerClientele != null) {
			return new ModelAndView("redirect:/conseillerClient/espace");
		} else if (conseillerMarketing != null) {
			return new ModelAndView("redirect:/conseillerMarketing/espace");
		} else {
			return new ModelAndView("redirect:/voyage/voyageListe");
		}

	}

	// Fonctionnalité ajouter
	@RequestMapping(value = "/clientAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		if (client != null) {
			modele.addAttribute("clAjout", client);
			return "ajouterClient";
		} else {
			modele.addAttribute("clAjout", new Client());
			return "ajouterClient";
		}
	}

	// commentaire
	@RequestMapping(value = "/clientSoumettreAjouter", method = RequestMethod.POST)
	public ModelAndView soumettreAjout(ModelMap modele, @ModelAttribute("clAjout") Client cIn, RedirectAttributes ra) {
		// Appel de la méthode service
		System.out.println(clientService.getClientByMail(cIn.getMail()));
		if (clientService.getClientByMail(cIn.getMail()) == null) {
			client = cIn;
			return new ModelAndView("redirect:clientAdresseAfficherAjouter");
		} else {
			ra.addFlashAttribute("msg", "Client déjà existant");
			return new ModelAndView("redirect:/voyage/voyageListe");
		}
	}

	@RequestMapping(value = "/clientAdresseAfficherAjouter", method = RequestMethod.GET)
	public String afficheAjoutAdresse(Model modele) {
		// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
		if (client.getAdresse() != null) {
			modele.addAttribute("addAjout", client.getAdresse());
			return "ajoutAdresse";
		} else {
			modele.addAttribute("addAjout", new Adresse());
			return "ajoutAdresse";
		}
	}

	// commentaire
	@RequestMapping(value = "/clientAdresseSoumettreAjouter", method = RequestMethod.POST)
	public ModelAndView soumettreAjoutAdresseClient(ModelMap modele, @ModelAttribute("addAjout") Adresse addIn,
			RedirectAttributes ra) {
		String message = "Bonjour " + client.getCivilite() + " " + client.getNom() + " " + client.getPrenom()
				+ "\n Pour valider votre inscription, veuillez copier coller le lien suivant dans votre navigateur: http://localhost:8080/666_ProjetBoVoyage/choixLogin/clientSoumettreActiver "
				+ "\n A bientot !";
		// Appel de la méthode service
		try {
			SendMailSSL sm = new SendMailSSL();
			sm.sendMail(client.getMail(), message);
			client.setAdresse(addIn);
			Client cOut = clientService.ajoutClientService(client);
			cOut.setRole(new Role());
			cOut.getRole().setClient(cOut);
			cOut.getRole().setRoleName("ROLE_CLIENT");
			roleService.ajoutRoleService(cOut.getRole());
			ra.addFlashAttribute("msg", "Bravo, validez votre mail!");
			return new ModelAndView("redirect:/voyage/voyageListe");
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "Echec, votre mail n'existe pas, veuillez le modifier");
			return new ModelAndView("redirect:clientAfficheAjouter");
		}

	}

	@RequestMapping(value = "/clientSoumettreActiver", method = RequestMethod.GET)
	public ModelAndView soumettreAjoutActiver(ModelMap modele, RedirectAttributes ra) {
		// Appel de la méthode service
		try {
			client.setActive(true);
			clientService.modifierClientService(client);
			ra.addFlashAttribute("msg", "Vous avez bien validé votre mail ! Vous pouvez vous connecter !");
			return new ModelAndView("redirect:/voyage/voyageListe");
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "Echec, votre session est expirée");
			return new ModelAndView("redirect:/voyage/voyageListe");
		}
	}

}
