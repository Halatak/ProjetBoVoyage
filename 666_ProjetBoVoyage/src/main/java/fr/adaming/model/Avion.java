package fr.adaming.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "avions")
public class Avion {

	// declaration des attributs
	private int idAvion;

	@Column(name = "description", columnDefinition = "VARCHAR(5000)")
	private String description;
	private double prix;

	@Lob
	private byte[] photo;

	@Transient
	private String img;

	// constructeurs
	public Avion() {
		super();
	}

	public Avion(String description, byte[] photo, String img, double prix) {
		super();
		this.description = description;
		this.photo = photo;
		this.img = img;
		this.prix = prix;
	}

	public Avion(int idAvion, String description, byte[] photo, String img, double prix) {
		super();
		this.idAvion = idAvion;
		this.description = description;
		this.photo = photo;
		this.img = img;
		this.prix = prix;
	}

	// getter et setter
	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
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

	// ToString
	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", description=" + description + ", prix=" + prix + ", photo="
				+ Arrays.toString(photo) + ", img=" + img + "]";
	}

}
