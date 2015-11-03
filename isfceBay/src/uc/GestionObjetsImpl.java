package uc;

import java.util.LinkedList;

import dal.DBOperations;
import launcher.Launcher;
import model.*;


public class GestionObjetsImpl implements GestionObjets{

	private Launcher launcher;
	
	public GestionObjetsImpl(Launcher l) {
		this.launcher = l;
	}
	
	@Override
	public boolean ajouterObjet(Objet object) {
		DBOperations dbOperations = launcher.getDBOperations();
		boolean yesNo = dbOperations.createObjet(object);
		if(yesNo){
			System.out.println("Nouvel objet ajouté");
			return true;
		}
		System.out.println("Le nouvel objet n'a pas pu être ajouté");
		return false;
	}

	@Override
	public boolean modifierObjet(int idObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerObjet(int idObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Objet choisirObjet(int idObjet) {
		DBOperations dbOperations = launcher.getDBOperations();
		return dbOperations.dbObtenirObjet(idObjet);
	}

	@Override
	public void voirObjets() {
		DBOperations dbOperations = launcher.getDBOperations();
		dbOperations.voirTousLesObjets();
		
	}

	@Override
	public void voirObjetsUtilisateur(Utilisateur utilisateur) {
		DBOperations dbOperations = launcher.getDBOperations();
		dbOperations.voirTousLesObjetsUtilisateurs(utilisateur.getId());
		
	}

	@Override
	public LinkedList<Objet> getObjets() {
		DBOperations dbOperations = launcher.getDBOperations();
		return dbOperations.getObjet();
	}

	@Override
	public LinkedList<Objet> getObjetsUtilisateur(int idUtilisateur) {
		DBOperations dbOperations = launcher.getDBOperations();
		return dbOperations.getObjetUtilisateur(idUtilisateur);
	}


}
