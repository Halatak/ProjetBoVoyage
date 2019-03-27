package fr.adaming.model;

import java.io.Serializable;

public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;

	// transformation de l'association UML
	private Dossier dossier;

	// Constructeur
	public Panier() {
		super();
	}

	// Getters and Setters
	public Panier(Dossier dossier) {
		super();
		this.dossier = dossier;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	@Override
	public String toString() {
		return "Panier [dossier=" + dossier + "]";
	}

}
