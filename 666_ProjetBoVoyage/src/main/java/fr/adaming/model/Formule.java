package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formules")
public class Formule {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f")
	private int id;
	@Column(name="type_f")
	private String typeFormule;
	
	//constructeurs
	public Formule() {
		super();
	}

	public Formule(String typeFormule) {
		super();
		this.typeFormule = typeFormule;
	}

	public Formule(int id, String typeFormule) {
		super();
		this.id = id;
		this.typeFormule = typeFormule;
	}

	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeFormule() {
		return typeFormule;
	}

	public void setTypeFormule(String typeFormule) {
		this.typeFormule = typeFormule;
	}

	@Override
	public String toString() {
		return "Formule [id=" + id + ", typeFormule=" + typeFormule + "]";
	}
	
	

}
