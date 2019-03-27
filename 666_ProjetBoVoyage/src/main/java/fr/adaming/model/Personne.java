package fr.adaming.model;

import java.util.Date;

public abstract class Personne {
	
	//attributs
	private String civilite;
	private String nom;
	private String prenom;
	private String telephone;
	private Date dateNaissance;
	private String numCarteBanquaire;
	
	//constructeurs
	public Personne() {
		super();
	}

	public Personne(String civilite, String nom, String prenom, String telephone, Date dateNaissance,
			String numCarteBanquaire) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.numCarteBanquaire = numCarteBanquaire;
	}

	public Personne(int id, String civilite, String nom, String prenom, String telephone, Date dateNaissance,
			String numCarteBanquaire) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.numCarteBanquaire = numCarteBanquaire;
	}

	//getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getNumCarteBanquaire() {
		return numCarteBanquaire;
	}

	public void setNumCarteBanquaire(String numCarteBanquaire) {
		this.numCarteBanquaire = numCarteBanquaire;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + ", dateNaissance=" + dateNaissance + ", numCarteBanquaire=" + numCarteBanquaire + "]";
	}
	
	
	
	
	

}
