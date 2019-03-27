package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends Personne implements Serializable{
	
	//Declaration des attributs
	
	private String mail;
	private String mdp;

	
	//Transformation de l'association UML en JAVA
	
	
	
	//constructeur
	
	public Client() {
		super();
	}
	
	public Client(String civilite, String nom, String prenom, String telephone, Date dateNaissance,
			String numCarteBanquaire, String mail, String mdp) {
		super(civilite, nom, prenom, telephone, dateNaissance, numCarteBanquaire);
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id, String civilite, String nom, String prenom, String telephone, Date dateNaissance,
			String numCarteBanquaire, String mail, String mdp) {
		super(id, civilite, nom, prenom, telephone, dateNaissance, numCarteBanquaire);
		this.mail = mail;
		this.mdp = mdp;
	}

	//getter et setter
	

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	

}
