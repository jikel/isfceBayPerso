package uc;

import dal.DBOperations;
import launcher.Launcher;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import org.apache.commons.lang.NotImplementedException;


//test SVN

public class GestionUtilisateursImpl implements GestionUtilisateurs {

	private Launcher launcher;
	
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
		System.out.println("L'utilisateur "+login+" est maintenant connect�");
		return true;
	}


	public boolean ajouterUtilisateur(Utilisateur user) {
		DBOperations dBOperations=launcher.getDBOperations();
		boolean bla = dBOperations.createUtilisateur(user);
		if (bla){
			System.out.println("Inscription r�ussie!");
			return true;
		}
		System.out.println("Inscription �chou�e! rip");
		return false;
	}

}
