package ihm;

import java.util.Scanner;

import launcher.Launcher;

import model.*;
import dal.*;

public class ConnexionConsole {

	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;

	public ConnexionConsole(Launcher l) {
		this.launcher = l;
		menuGeneral();
	}

	public void menuGeneral() {
		System.out.println("Menu Application IsfceBay");
		System.out.println("1. Connexion");
		System.out.println("2. Inscription");
		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();

		if (choix.equals("1")) {
			connexion();
		} 
		else if(choix.equals("2")){
			inscription();
		}
			else {
			System.out.println("L'entr�e semble erronn�e. Fin du programme.");
		}

	}
	public void inscription(){
		System.out.println("Entrez votre pseudo :");
		String pseudo = scanner.nextLine();
		System.out.println("Entez votre password");
		String password = scanner.nextLine();
		System.out.println("Entrez votre E-mail");
		String mail = scanner.nextLine();
		Utilisateur user = new Utilisateur(pseudo,mail,password);
		boolean userInscrit = launcher.getGestionUtilisateurs().ajouterUtilisateur(user);
		
	}
	public void connexion() {
		System.out.print("Login (=email) : ");
		String login = scanner.nextLine();
		System.out.print("Password : ");
		String password = scanner.nextLine();
		System.out.println("Log:" + login + ", pwd:" + password);
		boolean userConnectedlauncher = launcher.getGestionUtilisateurs()
				.connecterUtilisateur(login, password);
	}

}
