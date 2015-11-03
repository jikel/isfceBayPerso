package ihm;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Scanner;

import dal.DBOperations;
import dal.DBOperationsSQLite;
import launcher.Launcher;
import model.Categorie;
import model.Objet;
import model.Utilisateur;
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
		System.out.println("Voir liste objet + creer objet bidon");
		System.out.println("Test de la methode getObjet");
		System.out.println("Test de la methode getObjetUtilisateur");
		
		int choix = scanner.nextInt();

		if (choix == 1){
			launcher.getGestionObjets().voirObjets();
			
			creerObjetEnVente();
			
			launcher.getGestionObjets().voirObjets();


			//launcher.getGestionObjets().ajouterObjet(object)
			
			//System.out.println(launcher.getGestionObjets().choisirObjet(1).toString());
			
		}
		
		if (choix == 2){
			LinkedList <Objet> test = launcher.getGestionObjets().getObjets();
			System.out.println(test);
			
			
		}
		
		if (choix == 3){
			System.out.println(launcher.getGestionObjets().getObjetsUtilisateur(15));
			
		}
		
		else{
			System.out.println("Choix non valable");
		}
		
	}
	
	public boolean creerObjetEnVente() {
		System.out.println("Entrez le nom de l'objet à vendre :");
		String nomObjet = "test";
		System.out.println("Entrez la description de l'objet à vendre :");
		String descriptionObjet = "trucmuche";
		System.out.println("Entrez le prix de départ pour la vente aux enchères");
		double prixInitial = 125.20;
		System.out.println("Voulez vendre l'objet avec un prix fixe (O/N) ?");
		//String choix = scanner.nextLine();
		double prixAchatImmediat = 0;
//		if((choix.equals("O")) || (choix.equals("o"))) {
//			System.out.println("Entrez le prix d'achat immédiat de l'objet :");
//			prixAchatImmediat = scanner.nextDouble();
//		}
		java.util.Date date= new java.util.Date();
		Timestamp dateAjout =new Timestamp(date.getTime());	
		Timestamp dateCloture = dateAjout;
		dateCloture.setMonth(dateCloture.getMonth()+1);

		Objet newObjet = new Objet(nomObjet, descriptionObjet, prixInitial, prixAchatImmediat, dateAjout, dateCloture, 1, 1);
		return launcher.getGestionObjets().ajouterObjet(newObjet);
		
	}
	
}
