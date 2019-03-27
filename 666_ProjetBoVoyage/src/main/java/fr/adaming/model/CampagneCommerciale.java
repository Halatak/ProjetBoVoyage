package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	 @ManyToOne
	 @JoinColumn(name="con_id",referencedColumnName="id_con")
	 private ConseillerClientele conseillerClientele;
	 
	 
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
	
	
	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}
	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}
	@Override
	public String toString() {
		return "CampagneCommerciale [id=" + id + ", date=" + date + "]";
	}
	 
	 
	 

}
