
package ihm;

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
        System.out.println("Menu Application Allocine");
        System.out.println("1. Connexion");
        System.out.println("2. Inscription");
        System.out.print("Votre choix : ");
        String choix = scanner.nextLine();

        if (choix.equals("1")) {
            if(connexion()){
                while(true){
                    System.out.println("Que voulez vous faire? \n 1. Acheter des objets \n 2. Vendre des objets \n 3. voir les opperations en cours");
                    String choix2= scanner.nextLine();
                    if (choix2.equals("1")){
                        System.out.println("Choisir catégorie");
                        afficherCategorie();
                        String choix3 = scanner.nextLine();
                        System.out.println("\n Vous avez choisis la catégorie "+choix3);
                        //LinkedList<Objet> objets = launcher.getDBOperations().getObjetsViaCategorie(choix3);
                        //for(int i=0; i<
                    }
                    if (choix2.equals("2")){
                        afficherCategorie();
                        String choix3 = scanner.nextLine();
                    }
                    if (choix2.equals("3")){
                       
                    }
                }
            }
           
        }
        else if(choix.equals("2")){
            inscription();
        }
            else {
            System.out.println("L'entrée semble erronnée. Fin du programme.");
        }

    }
    public void afficherCategorie(){
        LinkedList<Categorie> categories = launcher.getDBOperations().getCategories();
        String result = "";
        for(int i=0;i<categories.size();i++){
            Categorie current = categories.get(i);
            result+= Integer.toString(current.getIdCategorie());
            result+=". ";
            result+=current.getNomCategorie();
            result+="\n";
        }
        System.out.println(result);
       
    }
    public boolean inscription(){
        System.out.println("Entrez votre pseudo :");
        String pseudo = scanner.nextLine();
        System.out.println("Entez votre password");
        String password = scanner.nextLine();
        System.out.println("Entrez votre E-mail");
        String mail = scanner.nextLine();
        Utilisateur user = new Utilisateur(pseudo,mail,password);
        return launcher.getGestionUtilisateurs().ajouterUtilisateur(user);
       
    }
    public boolean connexion() {
        System.out.print("Login (=email) : ");
        String login = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        System.out.println("Log:" + login + ", pwd:" + password);
        boolean userConnectedlauncher = launcher.getGestionUtilisateurs()
                .connecterUtilisateur(login, password);
        return userConnectedlauncher;
    }

}

