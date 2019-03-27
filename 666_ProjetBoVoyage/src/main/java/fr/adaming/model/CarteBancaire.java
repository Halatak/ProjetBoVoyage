package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cartebancaires")
public class CarteBancaire {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carteb")
	private int idCarte;
	private int numeroCarte;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	
	//transformation
	@OneToOne
	@JoinColumn(name="cl_id",referencedColumnName="id_cl")
	private Client client;
	
	//constructeurs
	public CarteBancaire() {
		super();
	}

	public CarteBancaire(int numeroCarte, String nom, String prenom, Date dateExpiration) {
		super();
		this.numeroCarte = numeroCarte;
		this.nom = nom;
		this.prenom = prenom;
		this.dateExpiration = dateExpiration;
	}

	public CarteBancaire(int idCarte, int numeroCarte, String nom, String prenom, Date dateExpiration) {
		super();
		this.idCarte = idCarte;
		this.numeroCarte = numeroCarte;
		this.nom = nom;
		this.prenom = prenom;
		this.dateExpiration = dateExpiration;
	}

	//getter et setter
	public int getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	public int getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//ToString
	@Override
	public String toString() {
		return "CarteBancaire [idCarte=" + idCarte + ", numeroCarte=" + numeroCarte + ", nom=" + nom + ", prenom="
				+ prenom + ", dateExpiration=" + dateExpiration + "]";
	}
	
}
