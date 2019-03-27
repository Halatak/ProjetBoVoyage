package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accompagnants")
public class Accompagnant extends Personne{
	
	//déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_accomp")
	private int numeroSequentiel;
	
	//Transformation de l'association UML en JAVA
	//Lier l'adresse a l'accompagnant
	@Embedded
	private Adresse adresse; //Il ne faudra pas oublier de SET l'adresse a l'accompagnant dans le DAO !
	
	//constructeurs
	public Accompagnant() {
		super();
	}

	public Accompagnant(int numeroSequentiel) {
		super();
		this.numeroSequentiel = numeroSequentiel;
	}

	//getter et setters
	public int getNumeroSequentiel() {
		return numeroSequentiel;
	}

	public void setNumeroSequentiel(int numeroSequentiel) {
		this.numeroSequentiel = numeroSequentiel;
	}

	//ToString
	@Override
	public String toString() {
		return "Accompagnant [numeroSequentiel=" + numeroSequentiel + ", adresse=" + adresse + ", getId()=" + getId()
				+ ", getCivilite()=" + getCivilite() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getTelephone()=" + getTelephone() + ", getDateNaissance()=" + getDateNaissance()
				+ ", getNumCarteBanquaire()=" + getNumCarteBanquaire() + "]";
	}
	
	

}
