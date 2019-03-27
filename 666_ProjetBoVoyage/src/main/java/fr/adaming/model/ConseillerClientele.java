package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conseillerClienteles")
public class ConseillerClientele extends Personne implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_con")
	private int idCon;
	private String mail;
	private String mdp;

	//Transformation de l'association UML en JAVA
	@OneToMany(mappedBy="conseillerClientele")
	private List<CampagneCommerciale> listeCampagneCommerciale;
	
	//dossier
	@OneToMany(mappedBy="conseillerClientele")
	private List<Dossier> listeDossier;
	
	//role
	@OneToMany(mappedBy="conseillerClientele")
	private List<Role> listeRole;
	//constructeur

	public ConseillerClientele() {
		super();
	}
	public ConseillerClientele(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}
	public ConseillerClientele(int idCon, String mail, String mdp) {
		super();
		this.idCon = idCon;
		this.mail = mail;
		this.mdp = mdp;
	}

	
	//getter et setter
	
	public int getIdCon() {
		return idCon;
	}
	public void setIdCon(int idCon) {
		this.idCon = idCon;
	}
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
	
	public List<CampagneCommerciale> getListeCampagneCommerciale() {
		return listeCampagneCommerciale;
	}
	public void setListeCampagneCommerciale(List<CampagneCommerciale> listeCampagneCommerciale) {
		this.listeCampagneCommerciale = listeCampagneCommerciale;
	}
	public List<Dossier> getListeDossier() {
		return listeDossier;
	}
	public void setListeDossier(List<Dossier> listeDossier) {
		this.listeDossier = listeDossier;
	}
	public List<Role> getListeRole() {
		return listeRole;
	}
	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}
	@Override
	public String toString() {
		return "ConseillerClientele [idCon=" + idCon + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	
}
