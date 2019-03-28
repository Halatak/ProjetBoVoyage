package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vpyages")
public class Voyage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_v")
	private int id;
	@Column(name = "datearr_v")
	private Date dateArrivee;
	@Column(name = "datedep_v")
	private Date dateDepart;
	@Column(name = "statut_v")
	private boolean statut;
	@Column(name = "nbplaces_v")
	private int nbPlaces;
	@Column(name = "prix_v")
	private double prix;
	
	//association uml
	@OneToOne
	@JoinColumn(name="dest_id",referencedColumnName="id_dest")
	private Destination destination;
	
	//voyage
	@OneToOne
	@JoinColumn(name="h_id",referencedColumnName="id_h")
	private Hebergement hebergement;
	
	//formule
	@OneToOne
	@JoinColumn(name="f_id",referencedColumnName="id_f")
	private Formule formule;
	
	//dossierOffreVoyage
	@OneToOne(mappedBy="voyage")
	private DossierOffreVoyage dossierOffreVoyage;
	
	//dossier
	@OneToMany(mappedBy="voyage")
	private List<Dossier> listeDossier;
	
	// constructeurs
	public Voyage() {
		super();
	}

	public Voyage(Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces, double prix) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
	}

	public Voyage(int id, Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces, double prix) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
	}

	// getters setters
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public DossierOffreVoyage getDossierOffreVoyage() {
		return dossierOffreVoyage;
	}

	public void setDossierOffreVoyage(DossierOffreVoyage dossierOffreVoyage) {
		this.dossierOffreVoyage = dossierOffreVoyage;
	}

	public List<Dossier> getListeDossier() {
		return listeDossier;
	}

	public void setListeDossier(List<Dossier> listeDossier) {
		this.listeDossier = listeDossier;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart + ", statut=" + statut
				+ ", nbPlaces=" + nbPlaces + ", prix=" + prix + "]";
	}

}
