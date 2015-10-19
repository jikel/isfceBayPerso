package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Profil {
	private int idProfil;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int sexe;
	private String adresse;
	private String pays;
	private Utilisateur utilisateur;
	
	
	public Profil(int id, String nom, String prenom, Date dateNaissance, int sexe, String adresse,
			String pays,Utilisateur user) {
		this.idProfil= id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.pays = pays;
		this.utilisateur = user;
	}
	public Utilisateur getUser(){
		return this.utilisateur;
	}
	public void setUser(Utilisateur user){
		this.utilisateur = user;
	}
	public int getIdProfil() {
		return idProfil;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	

	
}