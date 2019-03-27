package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campagneCommerciales")
public class CampagneCommerciale implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cc")
	 private int id;
	 // PDF à faire
	 private Date date;
	 
	 //Association uml en java
	 
	 //constructeur
	public CampagneCommerciale(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public CampagneCommerciale(Date date) {
		super();
		this.date = date;
	}
	public CampagneCommerciale() {
		super();
	}
	
	//getter et setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CampagneCommerciale [id=" + id + ", date=" + date + "]";
	}
	 
	 
	 

}
