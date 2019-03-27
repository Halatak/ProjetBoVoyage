package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Questionnaire {

	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_qu")
	private int id;
	private Date date;
	//PDF à faire
	
	//association uml en java
	
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
	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", date=" + date + "]";
	}
	
}
