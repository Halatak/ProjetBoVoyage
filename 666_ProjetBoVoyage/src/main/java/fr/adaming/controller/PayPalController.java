package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/paypal")
public class PayPalController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String accueil(){
		return "paypal";
	}

}
