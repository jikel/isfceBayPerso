package uc;

import java.util.LinkedList;

import model.*;

public interface GestionEncheres {

	public abstract boolean ajouterEnchere(Enchere enchere);
	
//	public abstract Enchere choisirEnchereGagnante (int idObjet);

	public abstract LinkedList<Enchere> voirEncheres();

	public abstract LinkedList<Enchere> voirEncheresUtilisateur(int idUtilisateur);

	public abstract LinkedList<Enchere> voirEncheresObjet(int idObjet);

}