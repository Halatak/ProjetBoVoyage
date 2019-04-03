package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accompagnants")
public class Accompagnant extends Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_accomp")
	private int numeroSequentiel;
	private String mail;

	// association uml
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;

	// constructeurs
	public Accompagnant() {
		super();
	}

	public Accompagnant(int numeroSequentiel, String mail) {
		super();
		this.mail = mail;
		this.numeroSequentiel = numeroSequentiel;
	}

	// getter et setters

	public int getNumeroSequentiel() {
		return numeroSequentiel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNumeroSequentiel(int numeroSequentiel) {
		this.numeroSequentiel = numeroSequentiel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// ToString
	@Override
	public String toString() {
		return "Accompagnant [numeroSequentiel=" + numeroSequentiel + ", getCivilite()=" + getCivilite() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getTelephone()=" + getTelephone()
				+ ", getDateNaissance()=" + getDateNaissance() + "]";
	}

}
