package ihm;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Scanner;

import dal.DBOperations;
import dal.DBOperationsSQLite;
import launcher.Launcher;
import model.Categorie;
import model.Enchere;
import model.Objet;
import model.Utilisateur;
import uc.GestionObjets;
import uc.GestionObjetsImpl;

/**
 * Cette classe sert à interagir avec l'utilisateur. Elle affiche le menu et
 * toutes les informations que verra l'utilisateur. C'est grâce à elle que
 * l'utilisateur pourra encoder des informations.
 */
public class MenuConsoleObjet {

	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;
	private GestionObjetsImpl test = new GestionObjetsImpl(launcher);

	public MenuConsoleObjet(Launcher l) {
		this.launcher = l;
		menuGeneral();
	}

	public void menuGeneral() {
		System.out.println("1. Voir liste objet + creer objet ");
		System.out.println("2. Test de la methode getObjet");
		System.out.println("3. Test de la methode getObjetUtilisateur");
		System.out.println("4. Voir liste enchere");
		System.out.println("5. Voir les categories");
		System.out.println("6. Voir objets par categorie et par utilisateur");
		System.out.println("7. Modifier un objet");
		System.out.println("8. Voir toutes les encheres d'un utilisateur");

		int choix = scanner.nextInt();

		if (choix == 1) {
			launcher.getGestionObjets().voirObjets();

			creerObjetEnVente();

			launcher.getGestionObjets().voirObjets();

			// launcher.getGestionObjets().ajouterObjet(object)

			// System.out.println(launcher.getGestionObjets().choisirObjet(1).toString());

		}

		else if (choix == 2) {
			LinkedList<Objet> test = launcher.getGestionObjets().getObjets();
			System.out.println(test);

		}

		else if (choix == 3) {
			// System.out.println(launcher.getGestionObjets().getObjetsUtilisateur(15));
			int test = 0;
			test = voirObjetsUtilisateur(launcher.getGestionObjets().getObjetsUtilisateur(15));
			System.out.println(test);
		}

		else if (choix == 4) {
			// LinkedList<Enchere> encheres =
			// launcher.getGestionEncheres().voirEncheres();
			// System.out.println(encheres);
			int test = voirEnchereObjet(launcher.getGestionEncheres().voirEncheres());
		}

		else if (choix == 5) {
			int test = voirCategorie(launcher.getGestionObjets().getCategories());
			System.out.println(test);
		}

		else if (choix == 6) {
			LinkedList<Objet> objets = launcher.getGestionObjets().getObjetsCategorieUtilisateur(15, 3);
			System.out.println(objets);
		}

		else if (choix == 7) {
			Objet test = launcher.getGestionObjets().choisirObjet(6);
			System.out.println(test.affichageUtilisateur());
			modifierObjet(test);
			test = launcher.getGestionObjets().choisirObjet(6);
			System.out.println(test.affichageUtilisateur());
		}

		else if (choix ==8){
			System.out.println("Voici les encheres de l'utilisateur id = 15");
			LinkedList<Enchere> encheres = launcher.getGestionEncheres().voirEncheresUtilisateur(15);
			int test = voirEnchereObjet(encheres);
		}
		
		else {
			System.out.println("Choix non valable");
		}

	}

	public boolean creerObjetEnVente() {
		System.out.println("Entrez le nom de l'objet a vendre :");
		scanner.nextLine();
		String nomObjet = scanner.nextLine();
		System.out.println("Entrez la description de l'objet a vendre :");
		String descriptionObjet = scanner.nextLine();
		System.out.println("Entrez le prix de depart pour la vente aux encheres");
		double prixInitial = scanner.nextDouble();
		System.out.println("Voulez vendre l'objet avec un prix fixe (O/N) ?");
		scanner.nextLine();
		String choix = scanner.nextLine();
		double prixAchatImmediat = 0;
		if((choix.equals("O")) || (choix.equals("o"))) {
			System.out.println("Entrez le prix d'achat immediat de l'objet :");
			prixAchatImmediat = scanner.nextDouble();
		}
		java.util.Date date = new java.util.Date();
		Timestamp dateAjout = new Timestamp(date.getTime());
		Timestamp dateCloture = dateAjout;
		dateCloture.setMonth(dateCloture.getMonth() + 1);
		
		// choix de la categorie
		System.out.println("Veuillez choisir une categorie pour l'objet a vendre");
		int choixCategorie = voirCategorie(launcher.getGestionObjets().getCategories());

		Objet newObjet = new Objet(nomObjet, descriptionObjet, prixInitial, prixAchatImmediat, dateAjout, dateCloture,
				1, choixCategorie);
		return launcher.getGestionObjets().ajouterObjet(newObjet);

	}

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
			System.out.println((i + 1) + ".\t" + categories.get(i).getNomCategorie() + "\n");
		}
		System.out.println("\nVeuillez choisir le numero de la categorie");
		choix = scanner.nextInt();
		if ((choix > 0) && (choix < taille + 1)) {
			// renvoie l'id de la categorie choisie
			return categories.get(choix - 1).getIdCategorie();
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
}
