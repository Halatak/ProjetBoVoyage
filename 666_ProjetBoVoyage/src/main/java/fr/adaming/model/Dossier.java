package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Dossier {

	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_do")
	private int id;
	private int numero;
	private String etat;
	
	//trnasformation de l'association uml en java
	
	
	//constructeur
	public Dossier(int id, int numero, String etat) {
		super();
		this.id = id;
		this.numero = numero;
		this.etat = etat;
	}
	public Dossier(int numero, String etat) {
		super();
		this.numero = numero;
		this.etat = etat;
	}
	public Dossier() {
		super();
	}
	
	//getter et setter
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
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", numero=" + numero + ", etat=" + etat + "]";
	}
	
	
	
}
