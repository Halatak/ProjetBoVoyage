package fr.adaming.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerClientService;
import fr.adaming.service.IConseillerMarketingService;

@Controller
@RequestMapping("/choixLogin")
@Scope("session")
public class ChoixLoginController {

	@Autowired
	private IClientService clientService;
	@Autowired
	private IConseillerClientService conClientService;
	@Autowired
	private IConseillerMarketingService conMarketService;
	private String mail;

	@PostConstruct // initialise les conseillers
	public void init() {
		// recuperer le context de spring security
		Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

		// recuperer le mail à partir du context
		String mail2 = authCxt.getName();
		mail = mail2;
	}

	@RequestMapping(value = "/choix", method = RequestMethod.GET)
	public ModelAndView afficheConseillerMarketing(RedirectAttributes ra) {

		for (int i2 = 0; i2 < conClientService.afficherListeConseillerClientService().size(); i2++) {
			if (mail.equals(conClientService.afficherListeConseillerClientService().get(i2).getMail())) {
				return new ModelAndView("redirect:/conseillerClient/espace");
			}
		}
		for (int i3 = 0; i3 < conMarketService.afficherListeConseillerMarkService().size(); i3++) {
			if (mail.equals(conMarketService.afficherListeConseillerMarkService().get(i3).getMail())) {

				return new ModelAndView("redirect:/conseillerMarketing/espace");
			}
		}
		for (int i = 0; i < clientService.afficherListeClientService().size(); i++) {
			if (mail.equals(clientService.afficherListeClientService().get(i).getMail())) {
				return new ModelAndView("redirect:/voyage/voyageListe");
			}
		}
		ra.addFlashAttribute("msg", "Mail non enregistré !!");
		return new ModelAndView("redirect:/voyage/voyageListe");

	}

}
