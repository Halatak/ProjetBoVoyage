package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private boolean active;

	
	//Transformation de l'association UML en JAVA
	//association avec carte bancaire
	@OneToOne(mappedBy="client")
	private CarteBancaire carteBancaire;
	
	//association avec accompagnant
	@OneToMany(mappedBy="client")
	private List<Accompagnant> listeAccompagnant;
	
	//association questionnaire
	@OneToOne(mappedBy="client")
	private Questionnaire questionnaire;
	
	//dossier
	@OneToOne(mappedBy="client")
	private Dossier dossier;
	
	//role
	@OneToOne(mappedBy="client")
	private Role Role;
	
	
	//constructeur
	
	public Client() {
		super();
	}

	public Client(String mail, String mdp, boolean active) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public Client(int idCl, String mail, String mdp, boolean active) {
		super();
		this.idCl = idCl;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
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

	
	
	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public List<Accompagnant> getListeAccompagnant() {
		return listeAccompagnant;
	}

	public void setListeAccompagnant(List<Accompagnant> listeAccompagnant) {
		this.listeAccompagnant = listeAccompagnant;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	
	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Client [idCl=" + idCl + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	

}
