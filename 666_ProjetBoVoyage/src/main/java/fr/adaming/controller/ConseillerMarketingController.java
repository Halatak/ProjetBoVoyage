package fr.adaming.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.adaming.model.ConseillerMarketing;
import fr.adaming.model.Hotel;
import fr.adaming.service.IAvionService;
import fr.adaming.service.IConseillerMarketingService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IVoitureService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/conseillerMarketing")
@Scope("session")
public class ConseillerMarketingController {

	// transformation de l'association uml en java
	@Autowired
	private IVoyageService voyageService;
	@Autowired
	private IAvionService avionService;
	@Autowired
	private IVoitureService voitureService;
	@Autowired
	private IFormuleService formuleService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IConseillerMarketingService conMarkService;
	private ConseillerMarketing conseillerMarketing;

	@PostConstruct // initialise les conseillers
	public void init() {
		// recuperer le context de spring security
		Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();

		// recuperer le mail à partir du context
		String mail = authCxt.getName();

		this.conseillerMarketing = conMarkService.getConseillerMarkByMail(mail);

	}

	// Sécurité
	@RequestMapping(value = "/espace", method = RequestMethod.GET)
	public String afficheConseillerMarketing() {

		return "redirect: voyageCMListe";
	}

	/*
	 * @RequestMapping(value = "/voyageCMListe", method = RequestMethod.GET)
	 * public ModelAndView afficheListe() { return new
	 * ModelAndView("accueilConseillerMarketing", "voyageCMListe",
	 * voyageService.afficherListeVoyageService()); }
	 */

	@RequestMapping(value = "/voyageCMListe", method = RequestMethod.GET)
	public String afficheListe(Model modele) {
		modele.addAttribute("voyageCMListe", voyageService.afficherListeVoyageService());
		modele.addAttribute("avionListe", avionService.afficherListeAvionService());
		modele.addAttribute("voitureListe", voitureService.afficherListeVoitureService());
		modele.addAttribute("hotelListe", hotelService.afficherListeHotelService());
		modele.addAttribute("formuleListe", formuleService.afficherListeFormuleService());
		return "accueilConseillerMarketing";
	}

	@RequestMapping(value = "/photoHo", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idHo) throws IOException {
		Hotel ho = hotelService.getHotelByIdService(idHo);
		if (ho.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(ho.getPhoto()));
		}
	}

}
