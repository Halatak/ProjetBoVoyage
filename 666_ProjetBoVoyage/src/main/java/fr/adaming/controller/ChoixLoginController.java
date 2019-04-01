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

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.ConseillerMarketing;
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
		// client = clientService.getClientByMailService(mail);
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

}
