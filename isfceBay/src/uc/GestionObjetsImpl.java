package uc;

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
		// TODO Auto-generated method stub
		DBOperations dbOperations = launcher.getDBOperations();
		dbOperations.voirTousLesObjets();
		
	}


}
