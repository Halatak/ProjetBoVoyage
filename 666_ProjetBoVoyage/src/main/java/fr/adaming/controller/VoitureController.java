package fr.adaming.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Hotel;
import fr.adaming.model.Voiture;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IVoitureService;
@Controller
@RequestMapping("/voiture")
@SessionAttributes("voiModif")
@Scope("session")
public class VoitureController {

	// transformation de l'association UML en java
	@Autowired
	private IVoitureService vService;

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
	@RequestMapping(value = "/voitureListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {

		return new ModelAndView("listeVoiture", "voitureListe", vService.afficherListeVoitureService());
	}

	// fonction ajouter voiture
	@RequestMapping(value = "/voitureAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		modele.addAttribute("voiAjout", new Voiture());
		return "ajouterVoiture";
	}

	@RequestMapping(value = "/voitureSoumettreAjouter", method = RequestMethod.POST)
	public ModelAndView soumettreAjout(Model modele, @ModelAttribute("voiAjout") Voiture vIn, RedirectAttributes ra, MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			vIn.setPhoto(file.getBytes());
		}else{
			if(vIn.getIdVoiture()!=0){
				Voiture des=(Voiture) modele.asMap().get("voiModif");
				vIn.setPhoto(des.getPhoto());
			}
		}
		
		// appel de la methode service
		Voiture vOut = vService.ajoutVoitureService(vIn);
		if (vOut.getIdVoiture() != 0) {
			return new ModelAndView("redirect:/conseillerMarketing/voyageCMListe");
		} else {
			ra.addFlashAttribute("msg", "L'ajout à échoué");
			return new ModelAndView("redirect:voitureAfficheAjout");
		}
	}

	// Modification
	@RequestMapping(value = "/voitureAfficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model model) {
		// lier un hotel au modèle MVC
		model.addAttribute("voiModif", new Voiture());
		return "modifierVoiture";
	}

	@RequestMapping(value = "/voitureSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(ModelMap modele, @ModelAttribute("voiModif") Voiture vIn, RedirectAttributes ra) {
		// appel de la méthode service
		try {
			vService.modifierVoitureService(vIn);
			return "redirect:voitureListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "La modification a échouée");
			return "redirect:voitureAfficheModifier";
		}
	}

	// Suppression
	@RequestMapping(value = "/voitureAfficheSupprimer", method = RequestMethod.GET)
	public String afficheSuppr(Model modele) {
		// lier un hotel au modèle MVC
		modele.addAttribute("voiSuppr", new Voiture());
		return "supprimerVoiture";
	}

	@RequestMapping(value = "/voitureSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(ModelMap modele, @ModelAttribute("voiSuppr") Voiture vIn, RedirectAttributes ra) {
		// appel de la methode service
		try {
			vService.supprVoitureService(vIn);;
			return "redirect:voitureListe";
		} catch (Exception e) {
			ra.addAttribute("msg", "La suppression a échouée");
			return "redirect:voitureAfficheSupprimer";
		}
	}

	// rechercher
	@RequestMapping(value = "/voitureAfficheRechercher", method = RequestMethod.GET)
	public String afficheSearch(Model modele) {

		// lier un hotel au modèle MVC
		modele.addAttribute("voiRechercher", new Voiture());
		return "rechercheVoiture";
	}

	@RequestMapping(value = "/soumettreRechercher", method = RequestMethod.POST)
	public ModelAndView soumettreRecherche(@ModelAttribute("voiRecher") Voiture vIn, RedirectAttributes ra) {
		// appel de la methode service
		Voiture vOut = vService.getVoitureByIdService(vIn.getIdVoiture());
		if (vOut != null) {
			return new ModelAndView("rechercheVoiture", "voiture", vOut);
		} else {
			ra.addFlashAttribute("msg", "La recherche à échouée");
			return new ModelAndView("redirect:voitureAfficheRerchercher");
		}
	}

	// les boutons
	@RequestMapping(value = "/voitureSoumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		vService.supprVoitureByIdService(id);
		return "redirect:voitureListe";
	}

	@RequestMapping(value = "/voitureSoumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Voiture vOut = vService.getVoitureByIdService(id);
		modele.addAttribute("voiModif", vOut);
		return "modifierVoiture";
	}
	
	@RequestMapping(value="/photoVoi",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idVoi) throws IOException{
		Voiture voi=vService.getVoitureByIdService(idVoi);
		if(voi.getPhoto()==null){
			return new byte[0];
		}else{
			return IOUtils.toByteArray(new ByteArrayInputStream(voi.getPhoto()));
		}
	}

}