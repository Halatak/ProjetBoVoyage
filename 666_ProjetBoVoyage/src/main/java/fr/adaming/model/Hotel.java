package fr.adaming.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hotels")
public class Hotel {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ho")
	private int id;
	private String nom;
	private String description;
	private int nbEtoiles;
	
	@Lob
	private byte[] photo;
	
	@Transient
	private String img;

	//constructeurs
	public Hotel() {
		super();
	}

	public Hotel(String nom, String description, int nbEtoiles, byte[] photo, String img) {
		super();
		this.nom = nom;
		this.description = description;
		this.nbEtoiles = nbEtoiles;
		this.photo = photo;
		this.img = img;
	}

	public Hotel(int id, String nom, String description, int nbEtoiles, byte[] photo, String img) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.nbEtoiles = nbEtoiles;
		this.photo = photo;
		this.img = img;
	}

	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbEtoiles() {
		return nbEtoiles;
	}

	public void setNbEtoiles(int nbEtoiles) {
		this.nbEtoiles = nbEtoiles;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nom=" + nom + ", description=" + description + ", nbEtoiles=" + nbEtoiles
				+ ", photo=" + Arrays.toString(photo) + ", img=" + img + "]";
	}
	
	
	
}
