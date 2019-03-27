package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assurances")
public class Assurance {

	// attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_as")
	private int id;
	private String type;
	private double prix;

	// transformation de l'association uml en java
	@OneToMany(mappedBy="assurance")
	private List<Dossier> listeDossier;
	
	// constructeur

	public Assurance(int id, String type, double prix) {
		super();
		this.id = id;
		this.type = type;
		this.prix = prix;
	}

	public Assurance(String type, double prix) {
		super();
		this.type = type;
		this.prix = prix;
	}

	public Assurance() {
		super();
	}

	// getter et setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public List<Dossier> getListeDossier() {
		return listeDossier;
	}

	public void setListeDossier(List<Dossier> listeDossier) {
		this.listeDossier = listeDossier;
	}

	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", prix=" + prix + "]";
	}

}
