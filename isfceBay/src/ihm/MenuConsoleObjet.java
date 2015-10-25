package ihm;

import java.util.LinkedList;
import java.util.Scanner;

import dal.DBOperations;
import dal.DBOperationsSQLite;
import launcher.Launcher;
import uc.GestionObjets;


/**
 * Cette classe sert à interagir avec l'utilisateur. 
 * Elle affiche le menu et toutes les informations que verra l'utilisateur.
 * C'est grâce à elle que l'utilisateur pourra encoder des informations.
 */
public class MenuConsoleObjet {
	
	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;

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
			
		}
		
		if (choix == 2){
			
		}
		
		if (choix == 3){
			
		}
		
		else{
			System.out.println("Choix non valable");
		}
		
	}

}
