package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ConseillerMarketing;

public interface IConseillerMarketingService {

	public ConseillerMarketing getConseillerMarkByMail(String mail);

	public List<ConseillerMarketing> afficherListeConseillerMarkService();

}
