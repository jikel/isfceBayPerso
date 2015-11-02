package uc;
import model.*;

public interface GestionUtilisateurs {

	public abstract boolean ajouterUtilisateur(Utilisateur user);

	public abstract boolean connecterUtilisateur(String login, String password);
	
	public abstract Utilisateur getCurrentUser();

}