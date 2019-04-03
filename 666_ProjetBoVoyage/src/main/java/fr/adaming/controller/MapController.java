package fr.adaming.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping(value = "/carte", method = RequestMethod.GET)
    public String afficheCarte(HttpServletRequest request) {

        return "testCarte";
    }
	
}
