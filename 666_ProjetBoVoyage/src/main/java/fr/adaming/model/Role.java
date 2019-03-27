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
@Table(name="roles")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private int id;
	private String roleName;

	//transformation de l'association UML en Java
	//avec le client
	@OneToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
	private Client client;
	//avec le conseiller clientele
	@ManyToOne
	@JoinColumn(name="conCl_id", referencedColumnName="id_con")
	private ConseillerClientele conseillerClientele;
	//avec le conseiller clientele
	@OneToOne
	@JoinColumn(name="conMark_id", referencedColumnName="id_conm")
	private ConseillerMarketing conseillerMarketing;


	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}

	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}

	public ConseillerMarketing getConseillerMarketing() {
		return conseillerMarketing;
	}

	public void setConseillerMarketing(ConseillerMarketing conseillerMarketing) {
		this.conseillerMarketing = conseillerMarketing;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

}
