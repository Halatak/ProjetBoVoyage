package fr.adaming.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.ConseillerClientele;
import fr.adaming.service.IConseillerClientService;

@Controller
@RequestMapping("/conseillerClient")
@Scope("session")
public class ConseillerClienteleController{

	//transformation de l'association UML en java
	@Autowired
	private IConseillerClientService conClientService;
	private ConseillerClientele conseillerClientele;
	
	@PostConstruct	//initialise les conseillers
	public void init(){
		//recuperer le context de spring security
		Authentication authCxt= SecurityContextHolder.getContext().getAuthentication();
		
		//recuperer le mail à partir du context
		String mail=authCxt.getName();
		
		this.conseillerClientele=conClientService.getConsClientByMail(mail);
	}
	

}
