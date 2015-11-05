package uc;

import java.util.LinkedList;

import model.*;

public interface GestionObjets {
	
	public abstract boolean ajouterObjet(Objet object);
	
	public abstract boolean modifierObjet (int idObjet);
	
	public abstract boolean supprimerObjet (int idObjet);
	
	public abstract Objet choisirObjet(int idObjet);
	
	public abstract LinkedList <Categorie> getCategories();
	
	public abstract void voirObjets();
	
	public abstract void voirObjetsUtilisateur(Utilisateur utilisateur);
	
	public abstract LinkedList<Objet> getObjets();
	
	public abstract LinkedList<Objet> getObjetsUtilisateur (int idUtilisateur);

	public abstract LinkedList<Objet> getObjetsCategorieUtilisateur (int idUtilisateur, int idCategorie);

}
