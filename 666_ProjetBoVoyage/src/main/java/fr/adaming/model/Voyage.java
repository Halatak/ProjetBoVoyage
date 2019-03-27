package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vpyages")
public class Voyage {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	@Column(name="datearr_v")
	private Date dateArrivee;
	@Column(name="datedep_v")
	private Date dateDepart;
	@Column(name="statut_v")
	private boolean statut;
	@Column(name="nbplaces_v")
	private int nbPlaces;
	
	//constructeurs
	public Voyage() {
		super();
	}

	public Voyage(Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
	}

	public Voyage(int id, Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
	}

	//getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart + ", statut=" + statut
				+ ", nbPlaces=" + nbPlaces + "]";
	}
	
	
}
