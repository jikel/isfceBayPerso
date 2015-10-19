package ihm;




import java.util.LinkedList;
import java.util.Scanner;

import launcher.Launcher;

import model.*;
import uc.*;
import dal.*;


public class EnchereConsole {

	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;
	private GestionEncheres gestionEncheres ;

	public EnchereConsole(Launcher l) {
		this.launcher = l;
		this.gestionEncheres = l.getGestionEncheres() ;
		menuGeneral();
	}

	public void menuGeneral() {
		System.out.println("Menu Application Ebay-Enchere");
		System.out.println("1. Voir Enchere ");
		System.out.println("2. Add  Enchere ");
		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();

		if (choix.equals("1")) {
			VoirListeDesEnchere();
		} 
		else if(choix.equals("2")){
			add();
		}
			else {
			System.out.println("L'entr�e semble erronn�e. Fin du programme.");
		}

	}
	public void add(){
		System.out.println("Entrez votre pseudo :");
		String pseudo = scanner.nextLine();
		System.out.println("Entez votre password");
		String password = scanner.nextLine();
		System.out.println("Entrez votre E-mail");
		String mail = scanner.nextLine();
		Utilisateur user = new Utilisateur(pseudo,mail,password);
		boolean userInscrit = launcher.getGestionUtilisateurs().ajouterUtilisateur(user);
		
	}
	
	/** 
	 * M�thode permettant d'afficher la liste des encheres
	 */
	public void VoirListeDesEnchere() {

		System.out.println("[ ID:"		+
				" Objet:"		+
				" Participant:"	+
				" Montant:"		+
				" Date:"		+
				" win:"						
				+ " ]");
		
			LinkedList<Enchere> lesEncheres = gestionEncheres.voirEncheres() ;
			for (Enchere obj : lesEncheres) {
				System.out.println("[ ID:"			+obj.getIdEnchere()+
									" Objet:"		+obj.getFkObjet()+
									" Participant:"	+obj.getParticipant()+
									" Montant:"		+obj.getMontantEnchere()+
									" Date:"		+obj.getDateEnchere()+
									" win:"		+obj.getEnchereGagnante()
									+ " ]");
			}

		
		
		
		


		
	}

}




