package model;

import java.sql.Timestamp;

public class Objet {
	private int idObjet;
	private String nomObjet;
	private String descriptionObjet;
	private double prixInitial;
	private double prixAchatImmediat;
	private Timestamp dateAjout;
	private Timestamp dateCloture;
	private int etatObjet;
	private int fkUtilisateur;
	private int fkCategorie;

	public Objet() {
		super();
	}

	// Constructeur avec id
	public Objet(int idObjet, String nomObjet, String descriptionObjet, double prixInitial, double prixAchatImmediat,
			Timestamp dateAjout, Timestamp dateCloture, int fkUtilisateur, int fkCategorie) {
		this.idObjet = idObjet;
		this.nomObjet = nomObjet;
		this.descriptionObjet = descriptionObjet;
		this.prixInitial = prixInitial;
		this.prixAchatImmediat = prixAchatImmediat;
		this.dateAjout = dateAjout;
		this.dateCloture = dateCloture;
		this.etatObjet = 1;
		this.fkUtilisateur = fkUtilisateur;
		this.fkCategorie = fkCategorie;
	}

	// Constructeur sans id
	public Objet(String nomObjet, String descriptionObjet, double prixInitial, double prixAchatImmediat,
			Timestamp dateAjout, Timestamp dateCloture, int fkUtilisateur, int fkCategorie) {
		this.nomObjet = nomObjet;
		this.descriptionObjet = descriptionObjet;
		this.prixInitial = prixInitial;
		this.prixAchatImmediat = prixAchatImmediat;
		this.dateAjout = dateAjout;
		this.dateCloture = dateCloture;
		this.etatObjet = 1;
		this.fkUtilisateur = fkUtilisateur;
		this.fkCategorie = fkCategorie;
	}

	public int getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}

	public String getNomObjet() {
		return nomObjet;
	}

	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}

	public String getDescriptionObjet() {
		return descriptionObjet;
	}

	public void setDescriptionObjet(String descriptionObjet) {
		this.descriptionObjet = descriptionObjet;
	}

	public double getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}

	public double getPrixAchatImmediat() {
		return prixAchatImmediat;
	}

	public void setPrixAchatImmediat(double prixAchatImmediat) {
		this.prixAchatImmediat = prixAchatImmediat;
	}

	public Timestamp getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Timestamp getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Timestamp dateCloture) {
		this.dateCloture = dateCloture;
	}

	public int getEtatObjet() {
		return etatObjet;
	}

	public void setEtatObjet(int etatObjet) {
		this.etatObjet = etatObjet;
	}

	public int getFkUtilisateur() {
		return fkUtilisateur;
	}

	public void setFkUtilisateur(int fkUtilisateur) {
		this.fkUtilisateur = fkUtilisateur;
	}

	public int getFkCategorie() {
		return fkCategorie;
	}

	public void setFkCategorie(int fkCategorie) {
		this.fkCategorie = fkCategorie;
	}

	public String affichageUtilisateur() {
		return "Nom = " + nomObjet + "\nDescription de l'objet = " + descriptionObjet + "\nPrix initial = "
				+ prixInitial + "\nPrix en Achat immediat = " + prixAchatImmediat + "\nDate de la mise en vente = "
				+ dateAjout + "\nDate de cloture de la vente = " + dateCloture + "\nEtat de l'objet = " + etatObjet
				+ "\n";
	}

	@Override
	public String toString() {
		return "Objet [idObjet=" + idObjet + ", nomObjet=" + nomObjet + ", descriptionObjet=" + descriptionObjet
				+ ", prixInitial=" + prixInitial + ", prixAchatImmediat=" + prixAchatImmediat + ", dateAjout="
				+ dateAjout + ", dateCloture=" + dateCloture + ", etatObjet=" + etatObjet + ", fkUtilisateur="
				+ fkUtilisateur + ", fkCategorie=" + fkCategorie + "]";
	}

}