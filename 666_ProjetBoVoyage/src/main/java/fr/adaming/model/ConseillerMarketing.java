package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conseillersMarketing")
public class ConseillerMarketing implements Serializable {
	private static final long serialVersionUID = 1L;

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conm")
	private int idConm;
	private String mail;
	private String mdp;

	// Constructeurs
	public ConseillerMarketing() {
		super();
	}

	public ConseillerMarketing(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public ConseillerMarketing(int idConm, String mail, String mdp) {
		super();
		this.idConm = idConm;
		this.mail = mail;
		this.mdp = mdp;
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

	// To String
	@Override
	public String toString() {
		return "ConseillerMarketing [idConm=" + idConm + ", mail=" + mail + ", mdp=" + mdp + "]";
	}

}
