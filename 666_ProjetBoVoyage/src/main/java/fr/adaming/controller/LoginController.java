package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// LOGIN DU CONSEILLER
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String affichePageLogin() {
		return "login";
	}
	
	@RequestMapping(value="/logoutUrl", method=RequestMethod.GET)
	public String affichePageLogout() {
		return "accueil";
	}
	
	@RequestMapping(value="/echecUrl", method=RequestMethod.GET)
	public String afficheEchec(ModelMap modele) {
		modele.addAttribute("erreur", true);
		return "login";
	}
	
	@RequestMapping(value="/deniedUrl", method=RequestMethod.GET)
	public String afficheDenied(ModelMap modele) {
		return "deniedPage";
	}
	
	// LOGIN DU CONSEILLER CLIENT
	
}
