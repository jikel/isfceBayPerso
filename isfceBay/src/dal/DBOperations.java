package dal;

import java.util.LinkedList;

import model.*;

public interface DBOperations {
	
	public abstract LinkedList<Utilisateur> getUtilisateurs();
	public abstract boolean createUtilisateur(Utilisateur newUtilisateur);
	public Utilisateur getUtilisateur(int id);
	public abstract Utilisateur getUtilisateur (String log, String pwd);
	public abstract LinkedList<Enchere> obtenirTousLesEncheres() ;
	public abstract boolean enregistrerUneEnchere( Enchere Enchere )  ;
	public abstract LinkedList <Enchere> getEnchereUtilisateur (int idUtilisateur);
	public abstract LinkedList<Objet> getObjet();
	public abstract LinkedList<Objet> getObjetUtilisateur(int idUtilisateur) ;
	public abstract boolean createObjet(Objet newObjet);
	public abstract Objet dbObtenirObjet(int idObjet);
	public abstract boolean modifierObjet(int idObjet, int typeModification, String modification);
	public abstract void voirTousLesObjets ();
	public abstract void voirTousLesObjetsUtilisateurs(int idUtilisateur);
	public abstract LinkedList<Objet> getObjetCategorieUtilisateur(int idUtilisateur, int idCategorie);
	public abstract LinkedList<Categorie> getCategories();
	public abstract Categorie getCategorie(int id);
	
}
