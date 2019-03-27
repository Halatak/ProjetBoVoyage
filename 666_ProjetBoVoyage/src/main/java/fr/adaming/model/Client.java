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
@Table(name="clients")
public class Client extends Personne implements Serializable{
	
	//Declaration des attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private int idCl;
	private String mail;
	private String mdp;

	
	//Transformation de l'association UML en JAVA
	
	
	
	//constructeur
	
	public Client() {
		super();
	}

	public Client(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int idCl, String mail, String mdp) {
		super();
		this.idCl = idCl;
		this.mail = mail;
		this.mdp = mdp;
	}

	//getter et setter
	

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	@Override
	public String toString() {
		return "Client [idCl=" + idCl + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	

}
