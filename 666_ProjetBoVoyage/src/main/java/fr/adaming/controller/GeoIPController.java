package fr.adaming.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.GeoIP;
import fr.adaming.service.RawDBGeoIPLocationService;

@RestController
public class GeoIPController {
//	
//	 private RawDBGeoIPLocationService locationService;
//     
//	    public GeoIPController() throws IOException {
//	        locationService = new RawDBGeoIPLocationService();
//	    }
//	     
//	    @RequestMapping("/GeoIPTest")
//	    public GeoIP getLocation(
//	      @RequestParam(value="ipAddress", required=true) String ipAddress
//	    ) throws Exception {
//	       
//	        GeoIPLocationService<String, GeoIP> locationService 
//	          = new RawDBGeoIPLocationService();
//	        return locationService.getLocation(ipAddress);
//	    }

}
