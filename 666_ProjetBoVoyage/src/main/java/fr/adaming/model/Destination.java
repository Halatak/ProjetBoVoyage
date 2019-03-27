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
@Table(name="destinations")
public class Destination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dest")
	private int idDestination;
	private String continent;
	private String pays;
	@Column(name="description", columnDefinition="VARCHAR(5000)")
	private String description;
	
	@Lob
	private byte[] photo;
	
	@Transient
	private String img;

	
	//Constructeurs
	public Destination() {
		super();
	}


	public Destination(String continent, String pays, String description, byte[] photo, String img) {
		super();
		this.continent = continent;
		this.pays = pays;
		this.description = description;
		this.photo = photo;
		this.img = img;
	}


	public Destination(int idDestination, String continent, String pays, String description, byte[] photo, String img) {
		super();
		this.idDestination = idDestination;
		this.continent = continent;
		this.pays = pays;
		this.description = description;
		this.photo = photo;
		this.img = img;
	}

	
	//getter et setter
	public int getIdDestination() {
		return idDestination;
	}


	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}


	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
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
		return "Destination [idDestination=" + idDestination + ", continent=" + continent + ", pays=" + pays
				+ ", description=" + description + ", photo=" + Arrays.toString(photo) + "]";
	}
	
}
