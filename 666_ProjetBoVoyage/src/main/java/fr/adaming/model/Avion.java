package fr.adaming.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="avions")
public class Avion {
	
	//declaration des attributs
	private int idAvion;
	
	@Column(name="description", columnDefinition="VARCHAR(5000)")
	private String description;
	
	@Lob
	private byte[] photo;
	
	@Transient
	private String img;
	
	//constructeurs
	public Avion() {
		super();
	}

	public Avion(String description, byte[] photo, String img) {
		super();
		this.description = description;
		this.photo = photo;
		this.img = img;
	}

	public Avion(int idAvion, String description, byte[] photo, String img) {
		super();
		this.idAvion = idAvion;
		this.description = description;
		this.photo = photo;
		this.img = img;
	}
	
	//getter et setter
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

	//ToString
	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", description=" + description + ", photo=" + Arrays.toString(photo) + "]";
	}
	
}
