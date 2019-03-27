package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="formules")
public class Formule {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f")
	private int id;
	@Column(name="type_f")
	private String typeFormule;
	
	//transformation de l'asso
	@OneToOne(mappedBy="formule")
	private Voyage voyage;
	
	//avion
	@OneToOne
	@JoinColumn(name="av_id",referencedColumnName="id_av")
	private Avion avion;
	
	//voiture
	@OneToOne
	@JoinColumn(name="voit_id",referencedColumnName="id_voit")
	private Voiture voiture;
	
	//hotel
	@OneToOne
	@JoinColumn(name="ho_id",referencedColumnName="id_ho")
	private Hotel hotel;
	//constructeurs
	public Formule() {
		super();
	}

	public Formule(String typeFormule) {
		super();
		this.typeFormule = typeFormule;
	}

	public Formule(int id, String typeFormule) {
		super();
		this.id = id;
		this.typeFormule = typeFormule;
	}

	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeFormule() {
		return typeFormule;
	}

	public void setTypeFormule(String typeFormule) {
		this.typeFormule = typeFormule;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Formule [id=" + id + ", typeFormule=" + typeFormule + "]";
	}
	
	

}
