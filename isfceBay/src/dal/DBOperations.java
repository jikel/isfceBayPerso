package dal;

import java.util.LinkedList;

import model.*;

public interface DBOperations {
	
	public abstract LinkedList<Utilisateur> getUtilisateurs();
	public abstract boolean createUtilisateur(Utilisateur newUtilisateur);
	public abstract Utilisateur getUtilisateur (String log, String pwd);
	public abstract LinkedList<Enchere> obtenirTousLesEncheres() ;
	public abstract boolean enregistrerUneEnchere( Enchere Enchere )  ;
	public abstract LinkedList<Objet> getObjet();
	public abstract LinkedList<Objet> getObjetUtilisateur(int idUtilisateur) ;
	public abstract boolean createObjet(Objet newObjet);
	public abstract Objet dbObtenirObjet(int idObjet);
	public abstract void voirTousLesObjets ();
	public abstract void voirTousLesObjetsUtilisateurs(int idUtilisateur);
	public abstract LinkedList<Categorie> getCategories();
	public abstract Categorie getCategorie(int id);
	
}
