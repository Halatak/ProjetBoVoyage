package fr.adaming.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import fr.adaming.model.Destination;
import fr.adaming.service.IDestinationService;

@Controller
@RequestMapping("/destination")
@SessionAttributes("desModif")
@Scope("session")
public class DestinationController {

	@Autowired
	private IDestinationService destService;

	// Liste Destination
	@RequestMapping(value = "/destinationListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("listeDestination", "destinationListe", destService.afficherListeDestinationService());
	}

	// Fonctionnalit� ajouter
	@RequestMapping(value = "/destinationAfficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("desAjout", new Destination());
		return "ajouterDestination";
	}

	@RequestMapping(value = "/destinationSoumettreAjouter", method = RequestMethod.POST)
	public String soumettreAjout(Model modele, @ModelAttribute("desAjout") Destination desIn, RedirectAttributes ra,
			MultipartFile file) throws Exception {
		// Appel de la m�thode service
		if(!file.isEmpty()){
			desIn.setPhoto(file.getBytes());
		}else{
			if(desIn.getIdDestination()!=0){
				Destination des=(Destination) modele.asMap().get("desModif");
				desIn.setPhoto(des.getPhoto());
			}
		}
		Destination desOut = destService.ajoutDestinationService(desIn);
		if (desOut.getIdDestination() != 0) {
			return "redirect:destinationListe";
		} else {
			ra.addFlashAttribute("msg", "l'ajout a �chou�");
			return "redirect:destinationAfficheAjout";
		}
	}

	// Modification
	@RequestMapping(value = "/destinationAfficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("desModif", new Destination());

		return "modifierDestination";
	}

	@RequestMapping(value = "/destinationSoumettreModifier", method = RequestMethod.POST)
	public String soumettreModif(ModelMap modele, @ModelAttribute("desModif") Destination desIn,
			RedirectAttributes ra) {
		// Appel de la m�thode service
		try {
			destService.modifierDestinationService(desIn);
			;
			return "redirect:destinationListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "modif a �chou�");
			return "redirect:destinationAfficheModifier";
		}

	}

	// Suppression
	@RequestMapping(value = "/destinationAfficheSupprimer", method = RequestMethod.GET)
	public String afficheSuppr(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("desSuppr", new Destination());

		return "supprimerDestination";
	}

	@RequestMapping(value = "/destinationSoumettreSupprimer", method = RequestMethod.POST)
	public String soumettreSuppr(ModelMap modele, @ModelAttribute("desSuppr") Destination desIn,
			RedirectAttributes ra) {
		// Appel de la m�thode service
		try {
			destService.supprDestinationService(desIn);
			return "redirect:destinationListe";
		} catch (Exception e) {
			ra.addFlashAttribute("msg", "suppr a �chou�");
			return "redirect:destinationAfficheSupprimer";
		}

	}

	// Rechercher
	@RequestMapping(value = "/destinationAfficheRechercher", method = RequestMethod.GET)
	public String afficheSearch(Model modele) {

		// Lier un �tudiant au mod�le MVC afin de l'utiliser dans le formulaire
		modele.addAttribute("desSearch", new Destination());

		return "rechercheDestination";
	}

	// Rechercher
	@RequestMapping(value = "/destinationSoumettreSearch", method = RequestMethod.POST)
	public ModelAndView soumettreSearch(@ModelAttribute("desSearch") Destination desIn, RedirectAttributes ra) {
		// Appel de la m�thode service

		Destination desOut = destService.getDestinationByIdService(desIn.getIdDestination());
		if (desOut != null) {
			return new ModelAndView("recherchedestination", "destination", desOut);
		} else {
			ra.addFlashAttribute("msg", "recherche a �chou�");
			return new ModelAndView("redirect:destinationAfficheRechercher");
		}

	}

	@RequestMapping(value = "/destinationSoumettre-supprLien", method = RequestMethod.GET)
	public String suppLien(@RequestParam("pId") int id) {
		destService.supprDestinationByIdService(id);
		return "redirect:destinationListe";
	}

	@RequestMapping(value = "/destinationSoumettre-modifLien", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int id) {
		Destination desOut = destService.getDestinationByIdService(id);
		modele.addAttribute("desModif", desOut);
		return "modifierDestination";
	}
	@RequestMapping(value="/photoDes",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idDest) throws IOException{
		Destination des=destService.getDestinationByIdService(idDest);
		if(des.getPhoto()==null){
			return new byte[0];
		}else{
			return IOUtils.toByteArray(new ByteArrayInputStream(des.getPhoto()));
		}
	}
}
