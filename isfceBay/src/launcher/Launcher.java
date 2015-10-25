package launcher;

import dal.DBOperations;
import dal.DBOperationsMock;
import dal.DBOperationsSQLite;
import ihm.ConnexionConsole;
import ihm.ConnexionSwing;
import ihm.EnchereConsole;
import ihm.MenuConsoleObjet;
import uc.GestionUtilisateurs;
import uc.GestionUtilisateursImpl;
import uc.GestionObjets;
import uc.GestionObjetsImpl;
import uc.GestionEncheres;
import uc.GestionEncheresImpl;

public class Launcher {

	private ConnexionConsole connexionConsole;
	private ConnexionSwing connexionSwing;
	private DBOperations dBOperations;
	private GestionUtilisateurs gestionUtilisateurs;
	private GestionObjets gestionObjets;
	private GestionEncheres gestionEncheres;	
	private EnchereConsole enchereConsole ;
	private MenuConsoleObjet objetConsole;

	public Launcher() {
		// CHOIX DB MOCK/SQLITE
		dBOperations=new DBOperationsMock();
		dBOperations = new DBOperationsSQLite();

		gestionUtilisateurs = new GestionUtilisateursImpl(this);
		gestionEncheres = new GestionEncheresImpl(this);
		gestionObjets = new GestionObjetsImpl(this);

		// CHOIX INTERFACE SWING/CONSOLE
		 //connexionSwing = new ConnexionSwing(this);
		 //connexionConsole=new ConnexionConsole(this);
		 objetConsole = new MenuConsoleObjet(this);
		 //enchereConsole = new EnchereConsole(this);
	}

	public static void main(String[] args) {
		Launcher launch = new Launcher();
		//launch.connexionConsole.connexion();
	}

	public ConnexionConsole getConnexionConsole() {
		return connexionConsole;
	}

	public ConnexionSwing getConnexionSwing() {
		return connexionSwing;
	}

	public GestionUtilisateurs getGestionUtilisateurs() {
		return gestionUtilisateurs;
	}
	
	public GestionObjets getGestionObjets() {
		return gestionObjets;
	}

	public GestionEncheres 	getGestionEncheres() {
		return gestionEncheres;
	}

	public DBOperations getDBOperations() {
		return dBOperations;
	}
	
}
