package uc;

import model.*;

public interface GestionObjets {
	
	public abstract boolean ajouterObjet(Objet object);
	
	public abstract boolean modifierObjet (int idObjet);
	
	public abstract boolean supprimerObjet (int idObjet);
	
	public abstract Objet choisirObjet(int idObjet);
	
	public abstract void voirObjets();
	
	public abstract void voirObjetsUtilisateur(Utilisateur utilisateur);


}
