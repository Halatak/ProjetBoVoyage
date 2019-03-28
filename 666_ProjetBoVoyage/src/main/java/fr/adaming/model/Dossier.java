package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dossiers")
public class Dossier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_do")
	private int id;
	private int numero;
	private String etat;
	
	//transformation de l'association uml en java
	@OneToOne
	@JoinColumn(name="cl_id",referencedColumnName="id_cl")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="as_id",referencedColumnName="id_as")
	private Assurance assurance;
	
	//voyage
	@ManyToOne
	@JoinColumn(name="v_id",referencedColumnName="id_v")
	private Voyage voyage;
	
	//conseillerClientele
	@ManyToOne
	@JoinColumn(name="con_id",referencedColumnName="id_con")
	private ConseillerClientele conseillerClientele;
	//constructeur
	public Dossier(int id, int numero, String etat) {
		super();
		this.id = id;
		this.numero = numero;
		this.etat = etat;
	}
	public Dossier(int numero, String etat) {
		super();
		this.numero = numero;
		this.etat = etat;
	}
	public Dossier() {
		super();
	}
	
	//getter et setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}
	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}
	@Override
	public String toString() {
		return "Dossier [id=" + id + ", numero=" + numero + ", etat=" + etat + "]";
	}
	
	
	
}
