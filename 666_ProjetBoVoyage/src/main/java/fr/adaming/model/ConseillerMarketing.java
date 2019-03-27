package fr.adaming.model;

import java.io.Serializable;
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
@Table(name = "conseillersMarketing")
public class ConseillerMarketing extends Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conm")
	private int idConm;
	private String mail;
	private String mdp;
	private boolean active;

	//transformation de l'association
	@OneToMany(mappedBy="conseillerMarketing")
	private List<DossierOffreVoyage> listeDossierOffreVoyage;
	
	//role
	@OneToOne(mappedBy="conseillerMarketing")
	private Role role;
	
	// Constructeurs
	public ConseillerMarketing() {
		super();
	}

	public ConseillerMarketing(String mail, String mdp, boolean active) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public ConseillerMarketing(int idConm, String mail, String mdp, boolean active) {
		super();
		this.idConm = idConm;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	// Getters Setters
	public int getIdConm() {
		return idConm;
	}

	public void setIdConm(int idConm) {
		this.idConm = idConm;
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

	public List<DossierOffreVoyage> getListeDossierOffreVoyage() {
		return listeDossierOffreVoyage;
	}

	public void setListeDossierOffreVoyage(List<DossierOffreVoyage> listeDossierOffreVoyage) {
		this.listeDossierOffreVoyage = listeDossierOffreVoyage;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// To String
	@Override
	public String toString() {
		return "ConseillerMarketing [idConm=" + idConm + ", mail=" + mail + ", mdp=" + mdp + "]";
	}

}
