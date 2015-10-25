package ihm;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Scanner;

import dal.DBOperations;
import dal.DBOperationsSQLite;
import launcher.Launcher;
import model.Objet;
import uc.GestionObjets;
import uc.GestionObjetsImpl;


/**
 * Cette classe sert à interagir avec l'utilisateur. 
 * Elle affiche le menu et toutes les informations que verra l'utilisateur.
 * C'est grâce à elle que l'utilisateur pourra encoder des informations.
 */
public class MenuConsoleObjet {
	
	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;
	private GestionObjetsImpl test = new GestionObjetsImpl(launcher);

	public MenuConsoleObjet(Launcher l) {
		this.launcher = l;
		menuGeneral();
	}
	
	public void menuGeneral(){
		System.out.println("Voir tous les objets dans la DB");
		System.out.println("Ajouter un objet dans la DB");
		System.out.println("Sélectionner un objet dans toute une liste");
		
		int choix = scanner.nextInt();

		if (choix == 1){
			System.out.println("Voici tous les objets");
			launcher.getGestionObjets().voirObjets();
			java.util.Date date= new java.util.Date();
			System.out.println(new Timestamp(date.getTime()));
			//launcher.getGestionObjets().ajouterObjet(object)
			
			//System.out.println(launcher.getGestionObjets().choisirObjet(1).toString());
			
		}
		
		if (choix == 2){
			System.out.println("Objet ajouté");
			
		}
		
		if (choix == 3){
			System.out.println("Objet sélectionné");
			
		}
		
		else{
			System.out.println("Choix non valable");
		}
		
	}

}
