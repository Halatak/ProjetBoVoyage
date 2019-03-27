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
@Table(name="hebergements")
public class Hebergement {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_h")
	private int id;
	
	private String typeHebergement;
	
	@Lob
	private byte[] photo;
	
	@Transient
	private String img;

	//constructeurs
	public Hebergement() {
		super();
	}

	public Hebergement(String typeHebergement, byte[] photo, String img) {
		super();
		this.typeHebergement = typeHebergement;
		this.photo = photo;
		this.img = img;
	}

	public Hebergement(int id, String typeHebergement, byte[] photo, String img) {
		super();
		this.id = id;
		this.typeHebergement = typeHebergement;
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

	public String getTypeHebergement() {
		return typeHebergement;
	}

	public void setTypeHebergement(String typeHebergement) {
		this.typeHebergement = typeHebergement;
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
		return "Hebergement [id=" + id + ", typeHebergement=" + typeHebergement + ", photo=" + Arrays.toString(photo)
				+ ", img=" + img + "]";
	}
	
	
}
