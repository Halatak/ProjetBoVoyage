package fr.adaming.model;

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
@Table(name="accompagnants")
public class Accompagnant extends Personne{
	
	//déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_accomp")
	private int numeroSequentiel;
	
	//association uml
	@ManyToOne
	@JoinColumn(name="cl_id",referencedColumnName="id_cl")
	private Client client;
	
	
	
	
	//constructeurs
	public Accompagnant() {
		super();
	}

	public Accompagnant(int numeroSequentiel) {
		super();
		this.numeroSequentiel = numeroSequentiel;
	}

	//getter et setters
	public int getNumeroSequentiel() {
		return numeroSequentiel;
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

	//ToString
	@Override
	public String toString() {
		return "Accompagnant [numeroSequentiel=" + numeroSequentiel + ", getCivilite()=" + getCivilite() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getTelephone()=" + getTelephone() + ", getDateNaissance()=" + getDateNaissance()
				+ "]";
	}
	
	

}
