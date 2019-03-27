package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dossiersOffresVoyages")
public class DossierOffreVoyage implements Serializable {
	private static final long serialVersionUID = 1L;
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dov")
	private int id;
	private int numero;
	private String etat;

	//trabsformation asso
	@OneToOne
	@JoinColumn(name="v_id",referencedColumnName="id_v")
	private Voyage voyage;
	
	//agence voyage
	@OneToOne
	@JoinColumn(name="ag_id",referencedColumnName="id_ag")
	private AgenceVoyage agenceVoyage;
	
	//conseiller marketing
	@ManyToOne
	@JoinColumn(name="conm_id",referencedColumnName="id_conm")
	private ConseillerMarketing conseillerMarketing;
	// Constructeur
	public DossierOffreVoyage() {
		super();
	}

	public DossierOffreVoyage(int numero, String etat) {
		super();
		this.numero = numero;
		this.etat = etat;
	}

	public DossierOffreVoyage(int id, int numero, String etat) {
		super();
		this.id = id;
		this.numero = numero;
		this.etat = etat;
	}

	// Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	
	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public AgenceVoyage getAgenceVoyage() {
		return agenceVoyage;
	}

	public void setAgenceVoyage(AgenceVoyage agenceVoyage) {
		this.agenceVoyage = agenceVoyage;
	}

	public ConseillerMarketing getConseillerMarketing() {
		return conseillerMarketing;
	}

	public void setConseillerMarketing(ConseillerMarketing conseillerMarketing) {
		this.conseillerMarketing = conseillerMarketing;
	}

	// To String
	@Override
	public String toString() {
		return "DossierOffreVoyage [id=" + id + ", numero=" + numero + ", etat=" + etat + "]";
	}

}
