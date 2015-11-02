
package ihm;

import java.sql.Timestamp;
import java.util.LinkedList;
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
		System.out.println("Menu Application Isfce-Bay");
		System.out.println("1. Connexion");
		System.out.println("2. Inscription");
		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();

		if (choix.equals("1")) {
			if (connexion()) {
				while (true) {
					System.out.println(
							"Que voulez vous faire? \n 1. Acheter des objets \n 2. Vendre des objets \n 3. voir les operations en cours");
					String choix2 = scanner.nextLine();
					if (choix2.equals("1")) {
						System.out.println("Choisir catégorie");
						afficherCategorie();
						String choix3 = scanner.nextLine();
						System.out.println("\n Vous avez choisis la catégorie " + choix3);
						// LinkedList<Objet> objets =
						// launcher.getDBOperations().getObjetsViaCategorie(choix3);
						// for(int i=0; i<
					}
					if (choix2.equals("2")) {
						afficherCategorie();
						String choix3 = scanner.nextLine();
					}
					
		/* -------------------------------------------------------------------------------------
		 * -------------------------------------------------------------------------------------
		 * ------------------------------------MA PARTIE---------------------------------------- 
		 * -------------------------------------------------------------------------------------
		 * -------------------------------------------------------------------------------------
		 */
					// Menu Opérations en cours
					if (choix2.equals("3")) {
						int choixVenteEnchere = 3;
						do {
							System.out.println(
									"1. Voir les objets que l'utilisateur a mis en vente \n2. Voir toutes les enchères que l'utilisateur suit");
							choixVenteEnchere = scanner.nextInt();
						} while ((choixVenteEnchere != 1) && (choixVenteEnchere != 2));

						// Voir objets en vente
						if (choixVenteEnchere == 1) {
							int choixObjetsCategorie = 3;
							do {
								System.out.println("1. Voir tous les objets \n2. Choisir une catégorie");
								choixObjetsCategorie = scanner.nextInt();
							} while ((choixObjetsCategorie != 1) && (choixObjetsCategorie != 2));

							// Voir tous les objets en vente
							if (choixObjetsCategorie == 1) {
								// launcher.getGestionObjets().voirObjetsUtilisateur(utilisateur);

							}

							// Choisir une catégorie d'objet à vendre
							if (choixObjetsCategorie == 2) {

							}

						}

						// Voir enchères suivies
						if (choixVenteEnchere == 2) {
							int choixEncheres = 3;
							do {
								System.out.println(
										"1. Voir tous les objets que vous avez mis en vente \n2. Choisir une catégorie");
								choixEncheres = scanner.nextInt();
							} while ((choixEncheres != 1) && (choixEncheres != 2));
						}
					}
				}
			}

		} else if (choix.equals("2")) {
			inscription();
		} else {
			System.out.println("L'entrée semble erronnée. Fin du programme.");
		}

	}

	public void afficherCategorie() {
		LinkedList<Categorie> categories = launcher.getDBOperations().getCategories();
		String result = "";
		for (int i = 0; i < categories.size(); i++) {
			Categorie current = categories.get(i);
			result += Integer.toString(current.getIdCategorie());
			result += ". ";
			result += current.getNomCategorie();
			result += "\n";
		}
		System.out.println(result);
	}

	public void afficherObjetsVente() {
		LinkedList<Objet> objets = launcher.getDBOperations().getObjet();
		String result = "";
		for (int i = 0; i < objets.size(); i++) {
			Objet current = objets.get(i);
			result += Integer.toString(current.getIdObjet());
			result += ". ";
			result += current.getNomObjet();
			result += "\n";
		}
		System.out.println(result);

	}

	public boolean inscription() {
		System.out.println("Entrez votre pseudo :");
		String pseudo = scanner.nextLine();
		System.out.println("Entez votre password");
		String password = scanner.nextLine();
		System.out.println("Entrez votre E-mail");
		String mail = scanner.nextLine();
		Utilisateur user = new Utilisateur(pseudo, mail, password);
		return launcher.getGestionUtilisateurs().ajouterUtilisateur(user);

	}

	public boolean connexion() {
		System.out.print("Login (=email) : ");
		String login = scanner.nextLine();
		System.out.print("Password : ");
		String password = scanner.nextLine();
		System.out.println("Log:" + login + ", pwd:" + password);
		boolean userConnectedlauncher = launcher.getGestionUtilisateurs().connecterUtilisateur(login, password);
		return userConnectedlauncher;
	}

	public boolean creerObjetEnVente() {
		System.out.println("Entrez le nom de l'objet à vendre :");
		String nomObjet = scanner.nextLine();
		System.out.println("Entrez la description de l'objet à vendre :");
		String descriptionObjet = scanner.nextLine();
		System.out.println("Entrez le prix de départ pour la vente aux enchères");
		double prixInitial = scanner.nextDouble();
		System.out.println("Voulez vendre l'objet avec un prix fixe (O/N) ?");
		String choix = scanner.nextLine();
		double prixAchatImmediat = (Double) null;
		if ((choix.equals("O")) || (choix.equals("o"))) {
			System.out.println("Entrez le prix d'achat immédiat de l'objet :");
			prixAchatImmediat = scanner.nextDouble();
		}
		java.util.Date date = new java.util.Date();
		Timestamp dateAjout = new Timestamp(date.getTime());
		Timestamp dateCloture = dateAjout;
		dateCloture.setMonth(dateCloture.getMonth() + 1);

		Objet newObjet = new Objet(nomObjet, descriptionObjet, prixInitial, prixAchatImmediat, dateAjout, dateCloture,
				1, 1);
		return launcher.getGestionObjets().ajouterObjet(newObjet);

	}

}
