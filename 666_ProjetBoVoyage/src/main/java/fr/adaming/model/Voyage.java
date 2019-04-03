package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vpyages")
public class Voyage implements Serializable {
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
	@Transient
	private int minuteDepart;
	@Transient
	private String heureDepart;
	@Transient
	private int minuteArrive;
	@Transient
	private String heureArrive;

	// association uml
	@OneToOne
	@JoinColumn(name = "dest_id", referencedColumnName = "id_dest")
	private Destination destination;

	// voyage
	@OneToOne
	@JoinColumn(name = "h_id", referencedColumnName = "id_h")
	private Hebergement hebergement;

	// formule
	@OneToMany(mappedBy = "voyage")
	private List<Formule> listeFormule;

	// dossierOffreVoyage
	@OneToOne(mappedBy = "voyage")
	private DossierOffreVoyage dossierOffreVoyage;

	// dossier
	@OneToMany(mappedBy = "voyage")
	private List<Dossier> listeDossier;

	// constructeurs
	public Voyage() {
		super();
	}

	public Voyage(Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces, double prix, String heureDepart,
			int minuteDepart, String heureArrive, int minuteArrive) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.heureDepart = heureDepart;
		this.minuteDepart = minuteDepart;
		this.heureArrive = heureArrive;
		this.minuteArrive = minuteArrive;
	}

	public Voyage(int id, Date dateArrivee, Date dateDepart, boolean statut, int nbPlaces, double prix,
			String heureDepart, int minuteDepart, String heureArrive, int minuteArrive) {
		super();
		this.id = id;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.statut = statut;
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		this.heureDepart = heureDepart;
		this.minuteDepart = minuteDepart;
		this.heureArrive = heureArrive;
		this.minuteArrive = minuteArrive;
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

	public int getMinuteDepart() {
		return minuteDepart;
	}

	public void setMinuteDepart(int minuteDepart) {
		this.minuteDepart = minuteDepart;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public int getMinuteArrive() {
		return minuteArrive;
	}

	public void setMinuteArrive(int minuteArrive) {
		this.minuteArrive = minuteArrive;
	}

	public String getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(String heureArrive) {
		this.heureArrive = heureArrive;
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

	public List<Formule> getListeFormule() {
		return listeFormule;
	}

	public void setListeFormule(List<Formule> listeFormule) {
		this.listeFormule = listeFormule;
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
