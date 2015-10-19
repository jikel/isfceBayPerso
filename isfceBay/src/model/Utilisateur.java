package model;

import java.text.SimpleDateFormat;

/**
 * Cette classe sert a stocker et echanger les donnees d'un utilisateur. <b>
 * Aucune methode autre que des getters et setter ne doit s'y trouver.</b>
 * 
 * @author Anas
 * @version 1.0
 * 
 */
public class Utilisateur {

	private int idUtilisateur;
	private String pseudo;
	private String mail;
	private String password;

	public Utilisateur(int id, String pseudo, String mail, String password){
		this.idUtilisateur = id;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
	}
	public Utilisateur(String pseudo, String mail, String password){
		this.idUtilisateur = 0;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
	}
	/**
	 * Simple getter pour obtenir le nom de l'objet courant de type Utilisateur.
	 * <b> Inutile de faire une javadoc pour cela, en g�n�ral. </b>
	 * 
	 * @return Le nom de l'utilisateur.
	 */
	public String getPseudo() {
		return pseudo;
	}
	public void setId(int id){
		this.idUtilisateur = id;
	}
	
	public int getId(){
		return this.idUtilisateur;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if (other instanceof Utilisateur) {
			Utilisateur autreUtilisateur = (Utilisateur) other;
			return (autreUtilisateur.pseudo.equals(this.pseudo));
		} else
			return false;
	}

}
