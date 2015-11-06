
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

					/*
					 * ---------------------------------------------------------
					 * ---------------------------------------------------------
					 * ------------------PARTIE OLIVIER-------------------------
					 * ---------------------------------------------------------
					 * ---------------------------------------------------------
					 */
					// Menu Opérations en cours
					if (choix2.equals("3")) {
						Utilisateur currentUtilisateur = launcher.getGestionUtilisateurs().getCurrentUser();
						LinkedList<Objet> objets = null;
						int choixVenteEnchere = 3;
						do {
							System.out.println(
									"1. Voir les objets que vous avez mis en vente \n2. Voir toutes les enchères que vous suivez");
							choixVenteEnchere = scanner.nextInt();
						} while ((choixVenteEnchere != 1) && (choixVenteEnchere != 2));

						// ******************************************
						// Voir objets mis en vente par l'utilisateur
						// ******************************************
						if (choixVenteEnchere == 1) {
							int choixObjetsCategorie = 3;
							do {
								System.out.println("1. Voir tous les objets \n2. Choisir une catégorie");
								choixObjetsCategorie = scanner.nextInt();
							} while ((choixObjetsCategorie != 1) && (choixObjetsCategorie != 2));

							int choixObjet = 0;
							// Voir tous les objets en vente
							if (choixObjetsCategorie == 1) {
								objets = launcher.getGestionObjets().getObjetsUtilisateur(currentUtilisateur.getId());
							}

							// Choisir une catégorie d'objet à vendre
							else if (choixObjetsCategorie == 2) {
								LinkedList<Categorie> categories = launcher.getGestionObjets().getCategories();
								int choixCategorie = voirCategorie(categories);
								objets = launcher.getGestionObjets()
										.getObjetsCategorieUtilisateur(currentUtilisateur.getId(), choixCategorie);
							}

							choixObjet = voirObjetsUtilisateur(objets);
							System.out.println("Voici les encheres relatives a cet objet:\n");
							LinkedList<Enchere> encheres = launcher.getGestionEncheres().voirEncheresObjet(choixObjet);
							voirEnchereObjet(encheres);

							modifierObjet(launcher.getGestionObjets().choisirObjet(choixObjet));

						}
						// ***************************************
						// Voir encheres suivies par l'utilisateur
						// ***************************************
						else if (choixVenteEnchere == 2) {
							System.out.println("Voici tous les objets sur lequels vous avez encheris");
							objets = launcher.getGestionObjets().getObjetsEnchere(currentUtilisateur.getId());
							int choixObjet = voirObjetsUtilisateur(objets);
							System.out.println("Voici les encheres relatives a cet objet:\n");
							LinkedList<Enchere> encheres = launcher.getGestionEncheres().voirEncheresObjet(choixObjet);
							voirEnchereObjet(encheres);

							// encherir sur l'objet

						}
					}
					/*
					 * ---------------------------------------------------------
					 * ---------------------------------------------------------
					 * ----------------FIN PARTIE OLIVIER-----------------------
					 * ---------------------------------------------------------
					 * ---------------------------------------------------------
					 */
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

	/*
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 * ------------------------METHODES OLIVIER---------------------------------
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 */
	public int voirObjetsUtilisateur(LinkedList<Objet> objets) {
		int taille = objets.size();
		int choix = 0;
		for (int i = 0; i < taille; i++) {
			System.out.println((i + 1) + ".");
			System.out.println(objets.get(i).affichageUtilisateur());

		}

		System.out
				.println("\nVeuillez choisir le numero de l'objet sur lequel vous desirez apporter des modifications");
		choix = scanner.nextInt();
		if ((choix > 0) && (choix < taille + 1)) {
			// renvoie l'id de l'objet choisi
			return objets.get(choix - 1).getIdObjet();
		} else {
			System.out.println("Choix non valable");
			return 0;
		}

	}

	public int voirEnchereObjet(LinkedList<Enchere> encheres) {
		int taille = encheres.size();
		for (int i = 0; i < taille; i++) {
			System.out.println((i + 1) + ".");
			System.out.println(encheres.get(i).affichageUtilisateur() + "Encherisseur = " + launcher
					.getGestionUtilisateurs().choisirUtilisateur(encheres.get(i).getParticipant()).getPseudo());
		}
		return 0;
	}

	public int voirCategorie(LinkedList<Categorie> categories) {
		int taille = categories.size();
		int choix = 0;
		for (int i = 0; i < taille; i++) {
			System.out.println((i + 1) + ".\t" + categories.get(i).getNomCategorie());
		}
		System.out.println("\nVeuillez choisir le numero de la categorie");
		choix = scanner.nextInt();
		if ((choix > 0) && (choix < taille + 1)) {
			// renvoie l'id de la categorie choisie
			return categories.get(choix).getIdCategorie();
		} else {
			System.out.println("Choix non valable");
			return 0;
		}
	}

	public void modifierObjet(Objet objetAModifier) {
		int choix = 0;
		System.out.println("1.\tModifier l'objet en vente");
		System.out.println("2.\tSupprimer l'objet en vente");
		choix = scanner.nextInt();

		if (choix == 1) {
			System.out.println("Quel champ voulez-vous modifier ?");
			System.out.println("1.\tNom de l'objet");
			System.out.println("2.\tDescription de l'objet");
			System.out.println("3.\tPrix initial");
			System.out.println("4.\tPrix en achat immediat");
			choix = scanner.nextInt();

			switch (choix) {
			case 1:
				System.out.println("Veuillez entrer le nouveau nom de l'objet : ");
				scanner.nextLine();
				String nom = scanner.nextLine();
				launcher.getGestionObjets().modifierObjet(objetAModifier.getIdObjet(), 1, nom);
				break;
			case 2:
				System.out.println("Veuillez entrer la nouvelle description de l'objet : ");
				scanner.nextLine();
				String description = scanner.nextLine();
				launcher.getGestionObjets().modifierObjet(objetAModifier.getIdObjet(), 2, description);
				break;
			case 3:
				System.out.println("Veuillez entrer le nouveau prix de départ pour les encheres : ");
				scanner.nextLine();
				String prix = scanner.nextLine();
				launcher.getGestionObjets().modifierObjet(objetAModifier.getIdObjet(), 3, prix);
				break;
			case 4:
				System.out.println("Veuillez entrer le nouveau prix en achat immediat : ");
				scanner.nextLine();
				String achat = scanner.nextLine();
				launcher.getGestionObjets().modifierObjet(objetAModifier.getIdObjet(), 4, achat);
				break;
			default:
				System.out.println("Choix non valable");
				break;
			}
		}

		else if (choix == 2) {
			System.out.println("L'objet n'est plus en vente");
			launcher.getGestionObjets().modifierObjet(objetAModifier.getIdObjet(), 5, "-1");
		}

		else {
			System.out.println("Choix non valable");
		}
	}

	// public boolean encherirObjet (int idEnchereGagnante){
	// Enchere newEnchere = null;
	// System.out.println();
	// return launcher.getGestionEncheres().ajouterEnchere(newEnchere);
	// }

	/*
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 * --------------------------FIN METHODES OLIVIER---------------------------
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 */
}
