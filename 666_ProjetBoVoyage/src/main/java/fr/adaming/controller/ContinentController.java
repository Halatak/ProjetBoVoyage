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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Continent;
import fr.adaming.model.Destination;
import fr.adaming.service.IContinentService;

@Controller
@RequestMapping("/continent")
@Scope("session")
public class ContinentController {

	@Autowired
	private IContinentService contService;
	
	// Liste Destination
	@RequestMapping(value = "/continentListe", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		return new ModelAndView("listeContinent", "continentListe", contService.afficherListeContinentService());
	}
	
	// Fonctionnalité ajouter
		@RequestMapping(value = "/continentAfficheAjouter", method = RequestMethod.GET)
		public String afficheAjout(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("contAjout", new Continent());
			return "ajouterContinent";
		}

		@RequestMapping(value = "/continentSoumettreAjouter", method = RequestMethod.POST)
		public ModelAndView soumettreAjout(Model modele, @ModelAttribute("contAjout") Continent contIn, RedirectAttributes ra,
				MultipartFile file) throws Exception {
			// Appel de la méthode service
			if(!file.isEmpty()){
				contIn.setPhoto(file.getBytes());
			}else{
				if(contIn.getIdContinent()!=0){
					Continent cont=(Continent) modele.asMap().get("contModif");
					contIn.setPhoto(cont.getPhoto());
				}
			}
			Continent contOut = contService.ajoutContinentService(contIn);
			if (contOut.getIdContinent() != 0) {
				return new ModelAndView("redirect:/conseillerMarketing/voyageCMListe");
			} else {
				ra.addFlashAttribute("msg", "l'ajout a échoué");
				return new ModelAndView("redirect:continentAfficheAjout");
			}
		}
		
		// Modification
		@RequestMapping(value = "/continentAfficheModifier", method = RequestMethod.GET)
		public String afficheModif(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("contModif", new Continent());

			return "modifierContinent";
		}

		@RequestMapping(value = "/continentSoumettreModifier", method = RequestMethod.POST)
		public String soumettreModif(ModelMap modele, @ModelAttribute("desModif") Continent contIn,
				RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				contService.modifierContinentService(contIn);
				return "redirect:continentListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "modif a échoué");
				return "redirect:continentAfficheModifier";
			}

		}
		
		// Suppression
		@RequestMapping(value = "/continentAfficheSupprimer", method = RequestMethod.GET)
		public String afficheSuppr(Model modele) {

			// Lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("contSuppr", new Continent());

			return "supprimerContinent";
		}

		@RequestMapping(value = "/continentSoumettreSupprimer", method = RequestMethod.POST)
		public String soumettreSuppr(ModelMap modele, @ModelAttribute("desSuppr") Continent contIn,
				RedirectAttributes ra) {
			// Appel de la méthode service
			try {
				contService.supprContinentService(contIn);;
				return "redirect:continentListe";
			} catch (Exception e) {
				ra.addFlashAttribute("msg", "suppr a échoué");
				return "redirect:continentAfficheSupprimer";
			}

		}
		
		@RequestMapping(value="/photoCont",produces=MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] getPhoto(int idCont) throws IOException{
			Continent cont=contService.getContinentByIdService(idCont);
			if(cont.getPhoto()==null){
				return new byte[0];
			}else{
				return IOUtils.toByteArray(new ByteArrayInputStream(cont.getPhoto()));
			}
		}
}
