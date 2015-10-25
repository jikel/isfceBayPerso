
package uc;

import dal.DBOperations;
import launcher.Launcher;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import org.apache.commons.lang.NotImplementedException;


//test SVN

public class GestionUtilisateursImpl implements GestionUtilisateurs {

	private Launcher launcher;
	private Utilisateur currentUser;
	
	public GestionUtilisateursImpl(Launcher l){
		this.launcher=l;
	}
	
	public boolean connecterUtilisateur(String login, String password) {
		
		DBOperations dBOperations=launcher.getDBOperations();
		Utilisateur utilisateur=dBOperations.getUtilisateur(login, password);
		if (utilisateur==null){
			System.out.println("Impossible de connecter l'utilisateur. Login+password incorrects.");
			return false;
		}
		currentUser = utilisateur;
		System.out.println("L'utilisateur "+login+" est maintenant connecté");
		return true;
	}


	public boolean ajouterUtilisateur(Utilisateur user) {
		DBOperations dBOperations=launcher.getDBOperations();
		boolean bla = dBOperations.createUtilisateur(user);
		if (bla){
			System.out.println("Inscription réussie!");
			return true;
		}
		System.out.println("Inscription échouée! rip");
		return false;
	}

	public Utilisateur getCurrentUser(){
		return currentUser;
	}
}

