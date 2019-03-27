package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="agences")
public class AgenceVoyage {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ag")
	private int id;
	private String telephone;
	private String nom;
	
	//transformation asso
	@OneToOne(mappedBy="agenceVoyage")
	private DossierOffreVoyage dossierOffreVoyage;
	//constructeurs
	public AgenceVoyage() {
		super();
	}

	public AgenceVoyage(String telephone, String nom) {
		super();
		this.telephone = telephone;
		this.nom = nom;
	}

	public AgenceVoyage(int id, String telephone, String nom) {
		super();
		this.id = id;
		this.telephone = telephone;
		this.nom = nom;
	}

	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	public DossierOffreVoyage getDossierOffreVoyage() {
		return dossierOffreVoyage;
	}

	public void setDossierOffreVoyage(DossierOffreVoyage dossierOffreVoyage) {
		this.dossierOffreVoyage = dossierOffreVoyage;
	}

	@Override
	public String toString() {
		return "AgenceVoyage [id=" + id + ", telephone=" + telephone + ", nom=" + nom + "]";
	}
	
	
}
