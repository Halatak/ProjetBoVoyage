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

@Entity
@Table(name="questionnaires")
public class Questionnaire {

	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_qu")
	private int id;
	private Date date;
	//PDF à faire
	
	//association uml en java
	@OneToOne
	@JoinColumn(name="cl_id",referencedColumnName="id_cl")
	private Client client;
	
	//constructeur
	public Questionnaire(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Questionnaire(Date date) {
		super();
		this.date = date;
	}
	public Questionnaire() {
		super();
	}
	
	//getter et setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", date=" + date + "]";
	}
	
}
