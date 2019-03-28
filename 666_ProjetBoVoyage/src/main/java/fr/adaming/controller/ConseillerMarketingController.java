package fr.adaming.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.ConseillerMarketing;
import fr.adaming.service.IConseillerMarketingService;

@Controller
@RequestMapping("/conseillerMarketing")
@Scope("session")
public class ConseillerMarketingController {
	
	//transformation de l'association uml en java
	
	@Autowired
	private IConseillerMarketingService conMarkService;
	private ConseillerMarketing conseillerMarketing;
	

	@PostConstruct // initialise les conseillers
	public void init(){
		//recuperer le context de spring security
		Authentication authCxt= SecurityContextHolder.getContext().getAuthentication();
	
		//recuperer le mail à partir du context
		String mail=authCxt.getName();
		
		this.conseillerMarketing=conMarkService.getConseillerMarkByMail(mail);
	
		
	}
	
}
