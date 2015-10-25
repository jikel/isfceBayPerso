package dal;

import java.util.LinkedList;
import launcher.Launcher;
import model.Categorie;
import model.Enchere;
import model.Objet;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import sun.text.normalizer.Utility;

public class DBOperationsMock implements DBOperations {

	private LinkedList<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();
	
	public DBOperationsMock() {
		Utilisateur utilisateur1 = new Utilisateur("anas","anas","123");
		utilisateurs.add(utilisateur1);
	}

	public LinkedList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public boolean createUtilisateur(Utilisateur newUtilisateur) {
		if (utilisateurs.contains(newUtilisateur))
			return false;
		else {
			utilisateurs.add(newUtilisateur);
			return true;
		}
	}

	public Utilisateur getUtilisateur(String log, String pwd) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getMail().equals(log) && utilisateur.getPassword().equals(pwd)){
				return utilisateur;
			}
		}
		return null;
	}

	@Override
	public LinkedList<Enchere> obtenirTousLesEncheres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enregistrerUneEnchere(Enchere Enchere) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Objet> getObjet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createObjet(Objet newObjet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Objet dbObtenirObjet(int idObjet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Categorie> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorie(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void voirTousLesObjets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voirTousLesObjetsUtilisateurs(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}


}
