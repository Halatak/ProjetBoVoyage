package fr.adaming.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass	//classe abstraite
public abstract class Personne {
	
	//attributs
	private String civilite;
	private String nom;
	private String prenom;
	private String telephone;
	private Date dateNaissance;
	
	
	
	//Transformation de l'association UML en JAVA
	//Lier l'adresse a l'accompagnant
	@Embedded
	private Adresse adresse; //Il ne faudra pas oublier de SET l'adresse a l'accompagnant dans le DAO !
	
	//constructeurs
	public Personne() {
		super();
	}

	public Personne(String civilite, String nom, String prenom, String telephone, Date dateNaissance) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}


	//getters setters


	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Personne [civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
	
	

}
