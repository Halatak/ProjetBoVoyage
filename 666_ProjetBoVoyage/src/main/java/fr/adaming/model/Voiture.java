package fr.adaming.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voit")
	private int idVoiture;
	private String marque;
	private double prix;

	@Column(name = "description", columnDefinition = "VARCHAR(5000)")
	private String description;

	@Lob
	private byte[] photo;

	@Transient
	private String img;

	// Constructeurs
	public Voiture() {
		super();
	}

	public Voiture(String marque, String description, byte[] photo, String img, double prix) {
		super();
		this.marque = marque;
		this.description = description;
		this.photo = photo;
		this.img = img;
		this.prix = prix;
	}

	public Voiture(int idVoiture, String marque, String description, byte[] photo, String img, double prix) {
		super();
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.description = description;
		this.photo = photo;
		this.img = img;
		this.prix = prix;
	}

	// getter et setter
	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", marque=" + marque + ", prix=" + prix + ", description="
				+ description + ", photo=" + Arrays.toString(photo) + ", img=" + img + "]";
	}

}
