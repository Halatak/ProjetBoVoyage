package fr.adaming.model;

import fr.adaming.model.Mail;

public class SendMailSSL {
	public SendMailSSL() {
		super();
	}

	public int sendMail(String destinataire, String message) throws Exception {
		// Ton mail, le mdp de ton mail, le destinataire, le sujet, et l'objet
		int a = 0;
		Mail.send("adaming.fr.nettoyeur@gmail.com", "nettoyagedetableau", destinataire, "BoVOyage", message);
		// Message et destinataire sont des variables afin d'envoyer le mail à
		// la bonne personne pour "destinataire", et de personnaliser
		// le message avec "message" selon la personne.

		a++;
		return a;
	}

	public int sendMailDeux(String destinataire, String message) throws Exception {
		// Ton mail, le mdp de ton mail, le destinataire, le sujet, et l'objet
		int a = 0;
		MailDeux.send("adaming.fr.nettoyeur@gmail.com", "nettoyagedetableau", destinataire, "BoVOyage", message);
		// Message et destinataire sont des variables afin d'envoyer le mail à
		// la bonne personne pour "destinataire", et de personnaliser
		// le message avec "message" selon la personne.

		a++;
		return a;
	}
}
