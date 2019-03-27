package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	// To String
	@Override
	public String toString() {
		return "DossierOffreVoyage [id=" + id + ", numero=" + numero + ", etat=" + etat + "]";
	}

}
