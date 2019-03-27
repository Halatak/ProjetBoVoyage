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
@Table(name="continents")
public class Continent {
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conti")
	private int idContinent;
	
	@Column(name="description", columnDefinition="VARCHAR(5000)")
	private String description;
	
	@Lob
	private byte[] photo;
	
	@Transient
	private String img;

	//constructeurs
	public Continent() {
		super();
	}

	public Continent(String description, byte[] photo, String img) {
		super();
		this.description = description;
		this.photo = photo;
		this.img = img;
	}

	public Continent(int idContinent, String description, byte[] photo, String img) {
		super();
		this.idContinent = idContinent;
		this.description = description;
		this.photo = photo;
		this.img = img;
	}

	//getter et setter
	public int getIdContinent() {
		return idContinent;
	}

	public void setIdContinent(int idContinent) {
		this.idContinent = idContinent;
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
		return "Continent [description=" + description + ", photo=" + Arrays.toString(photo) + "]";
	}

}
