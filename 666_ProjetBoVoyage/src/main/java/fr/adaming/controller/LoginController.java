package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.service.IVoyageService;

@Controller
public class LoginController {

	@Autowired
	private IVoyageService voyageService;

	// LOGIN DU CONSEILLER
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String affichePageLogin() {
		return "login";
	}

	@RequestMapping(value = "/logoutUrl", method = RequestMethod.GET)
	public String affichePageLogout() {
		return "redirect:voyageListeDD";
	}

	@RequestMapping(value = "/echecUrl", method = RequestMethod.GET)
	public String afficheEchec(ModelMap modele, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "Connexion échouée");
		return "redirect:/voyage/voyageListe";
		// modele.addAttribute("erreur", true);
		// return "login";
	}

	@RequestMapping(value = "/deniedUrl", method = RequestMethod.GET)
	public String afficheDenied(ModelMap modele) {
		return "deniedPage";
	}

	@RequestMapping(value = "/voyageListeDD", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("accueil", "voyageListe", voyageService.afficherListeVoyageService());
	}

	// LOGIN DU CONSEILLER CLIENT

}
