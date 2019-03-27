package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assurances")
public class Assurance {

	//attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_as")
	private int id;
	private String type;

	//transformation de l'association uml en java
	
	//constructeur
	
	
	public Assurance(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Assurance(String type) {
		super();
		this.type = type;
	}
	public Assurance() {
		super();
	}

	//getter et setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + "]";
	}
	
	
}
