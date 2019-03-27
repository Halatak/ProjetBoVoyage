package fr.adaming.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Adresse {
	
	//déclaration des attributs
	@Column(name="id_num")
	private int numero;
	private String rue;
	private String ville;
	private String codePostal;
	
	//constructeurs
	public Adresse() {
		super();
	}

	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Adresse(int numero, String rue, String ville, String codePostal) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	
	//getter et setter
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	//ToString
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}	

}
