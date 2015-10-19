package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import model.*;

public class DBOperationsSQLite implements DBOperations {

	private static String dbUrl="jdbc:sqlite:src/ISFCEBAY.sqlite";
	
	public DBOperationsSQLite() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public LinkedList<Utilisateur> getUtilisateurs() {

		LinkedList<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();
		Connection c = null;
		Statement stmt = null;

		try {
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur;");

			while (rs.next()) {
				String idToCast = rs.getString("idUtilisateur");
				int id = Integer.parseInt(idToCast);
				String pseudo = rs.getString("pseudo");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				/*
				System.out.println("ID = " + id);
				System.out.println("NOM = " + nom);
				System.out.println("MAIL = " + mail);
				System.out.println("PASSWORD = " + password);
				*/
				Utilisateur utilisateur = new Utilisateur(id,pseudo,mail,password);
				utilisateurs.add(utilisateur);
			}
			
			rs.close();
			stmt.close();
			c.close();
			return (utilisateurs);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}
	

	public boolean createUtilisateur(Utilisateur newUtilisateur) {

		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
						
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Utilisateur(pseudo, email, password) VALUES(?, ?, ?);");
			requeteSQLPreparee.setString(1, newUtilisateur.getPseudo());
			requeteSQLPreparee.setString(2, newUtilisateur.getMail());
			requeteSQLPreparee.setString(3, newUtilisateur.getPassword());
						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la m�thode executeQuery, mais cette m�thode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
			//newUtilisateur.setId(this.getUtilisateur(newUtilisateur.getPseudo(), newUtilisateur.getPassword()).getId());
						
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public boolean createProfil(Profil profilToAdd) {

		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);			
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Profil( nom, prenom, dateNaissance, sexe, adresse, pays,idUtilisateur) VALUES( ?, ?, ?, ?, ?, ?, ?);");
			requeteSQLPreparee.setString(1, profilToAdd.getNom());
			requeteSQLPreparee.setString(2, profilToAdd.getPrenom());
			requeteSQLPreparee.setString(3, profilToAdd.getDateNaissance().toString());
			requeteSQLPreparee.setString(4, Integer.toString(profilToAdd.getSexe()));
			requeteSQLPreparee.setString(5, profilToAdd.getAdresse());
			requeteSQLPreparee.setString(6, profilToAdd.getPays());
			requeteSQLPreparee.setString(7, Integer.toString(profilToAdd.getUser().getId()));
						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la m�thode executeQuery, mais cette m�thode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public Categorie getCategorie(int id){
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Categorie categorie = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Categorie WHERE idCategorie=?");
			stmt.setString(1, Integer.toString(id));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nomCat = rs.getString("nomCategorie");
				categorie = new Categorie(id,nomCat);
			}
			return categorie;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}	
	}
	public Utilisateur getUtilisateur (int id){

		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Utilisateur utilisateur = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur=?");
			stmt.setString(1, Integer.toString(id));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String pseudo = rs.getString("fkpseudo");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				utilisateur = new Utilisateur(id,pseudo,mail,password);
			}
			return utilisateur;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	
	}
	public Utilisateur getUtilisateur(String log, String pwd) {
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Utilisateur utilisateur = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(true);
			stmt = c.prepareStatement("SELECT * FROM Utilisateur WHERE ( pseudo = ? OR email = ? ) AND password= ?");
			stmt.setString(1, log);
			stmt.setString(2, log);
			stmt.setString(3, pwd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("idUtilisateur");
				String pseudo = rs.getString("pseudo");
				String mail = rs.getString("email");
				String password = rs.getString("password");
				utilisateur = new Utilisateur(id,pseudo,mail,password);
			}
			return utilisateur;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}
	public Profil getProfil(Utilisateur user) {
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Profil profil = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Profil WHERE  fkUtilisateur=?");
			stmt.setString(1, Integer.toString(user.getId()));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String idToCast = rs.getString("idProfil");
				int id = Integer.parseInt(idToCast);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				Date naissance = rs.getDate("dateNaissance");
				String sexeToCast = rs.getString("sexe");
				int sexe = Integer.parseInt(sexeToCast);
				String adresse = rs.getString("adresse");
				String pays = rs.getString("pays");
				profil = new Profil(id,nom,prenom,naissance,sexe,adresse,pays,user);
			}
			return profil;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}
	
	
	public boolean createObjet(Objet newObjet){
		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
						
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Objet(idObjet, nomObjet, descriptionObjet, prixInitial, prixAchatImmediat, dateAjout, dateCloture, etatObjet, fkUtilisateur, fkCategorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			requeteSQLPreparee.setString(1, Integer.toString(newObjet.getIdObjet()));
			requeteSQLPreparee.setString(2, newObjet.getNomObjet());
			requeteSQLPreparee.setString(3, newObjet.getDescriptionObjet());
			requeteSQLPreparee.setString(4, Double.toString(newObjet.getPrixInitial()));
			requeteSQLPreparee.setString(5, Double.toString(newObjet.getPrixAchatImmediat()));
			requeteSQLPreparee.setString(6, newObjet.getDateAjout().toString());
			requeteSQLPreparee.setString(7, newObjet.getDateCloture().toString());
			requeteSQLPreparee.setString(8, Integer.toString(newObjet.getEtatObjet()));
			requeteSQLPreparee.setString(9, Integer.toString(newObjet.getFkUtilisateur()));
			requeteSQLPreparee.setString(10, Integer.toString(newObjet.getFkCategorie()));

						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la m�thode executeQuery, mais cette m�thode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
						
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}	
	}
	public Objet dbObtenirObjet(int idObjet) {
		// Objet de connexion a la db
		Connection connectionDB = null;
		// Requete SQL "preparee", ce qui signifie "parametree"
		PreparedStatement requeteSQLPreparee = null;

		// Variable pour stocker l'objet sour forme d'un objet de type "objet", lorsqu'on l'aura trouve.
		Objet objetTrouve=null;
		
		try {
			// Obtention d'une connexion vers la DB
			connectionDB = DriverManager.getConnection(dbUrl);
			// La base de donn�es se mettra a jour lorsqu'on la modifiera (necessaire).
			connectionDB.setAutoCommit(true);
						
			// On met des ? a chaque parametre
			requeteSQLPreparee = connectionDB.prepareStatement("SELECT * FROM Objet WHERE idObjet=? ");
			// Le ? est remplace par l'id de l'objet
			requeteSQLPreparee.setString(1, Integer.toString(idObjet));

			// On execute la requete SQL
			// Attention, pour un INSERT, il faut une autre methode que executeQuery (voir autres methodes de cette classe)
			ResultSet resultatRequeteSQL = requeteSQLPreparee.executeQuery();

			// Si la requ�te SQL a trouve au moins un objet avec le bon id, on rentre dans le if
			if (resultatRequeteSQL.next()) {
				
				// On enregistre toutes les donnees de l'objet dans des variables
				String nomObjet = resultatRequeteSQL.getString("nomObjet");
				String descriptionObjet = resultatRequeteSQL.getString("descriptionObjet");
				double prixInitial = resultatRequeteSQL.getDouble("prixInitial");
				double prixAchatImmediat = resultatRequeteSQL.getDouble("prixAchatImmediat");
				Timestamp dateAjout = resultatRequeteSQL.getTimestamp("dateAjout");
				Timestamp dateCloture = resultatRequeteSQL.getTimestamp("dateCloture");
				int etatObjet = resultatRequeteSQL.getInt("etatObjet");
				int fkUtilisateur = resultatRequeteSQL.getInt("fkUtilisateur");
				int fkCategorie = resultatRequeteSQL.getInt("fkCategorie");
			
				// Creation d'un objet DTO (transfert), pour stocker les informations de l'objet
				objetTrouve = new Objet();
				objetTrouve.setIdObjet(idObjet);
				objetTrouve.setNomObjet(nomObjet);
				objetTrouve.setDescriptionObjet(descriptionObjet);
				objetTrouve.setPrixInitial(prixInitial);
				objetTrouve.setPrixAchatImmediat(prixAchatImmediat);
				objetTrouve.setDateAjout(dateAjout);
				objetTrouve.setDateCloture(dateCloture);
				objetTrouve.setEtatObjet(etatObjet);
				objetTrouve.setFkUtilisateur(fkUtilisateur);
				objetTrouve.setFkCategorie(fkCategorie);
			}
			
			// Fermeture des ressources (obligatoire pour ne pas remplir toute la memoire du PC)
			resultatRequeteSQL.close();
			requeteSQLPreparee.close();
			connectionDB.close();
			
			// Le client trouve est retourne, ou null si aucun objet de la DB n'avait le bon id
			return objetTrouve;
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}	
	
	
	
	public LinkedList<Objet> getObjet() {

		LinkedList<Objet> objets = new LinkedList<Objet>();
		Connection c = null;
		Statement stmt = null;

		try {
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Objet ORDER BY dateCloture;");

			while (rs.next()) {
				String idToCast = rs.getString("idObjet");
				int id = Integer.parseInt(idToCast);
				String nomObjet = rs.getString("nomObjet");
				String descriptionObjet = rs.getString("descriptionObjet");
				String prixToCast = rs.getString("prixInitial");
				double prixInitial = Double.parseDouble(prixToCast);
				String prixAchatImmediatToCast = rs.getString("prixAchatImmediat");
				double prixAchatImmediat = Double.parseDouble(prixAchatImmediatToCast);
				Timestamp dateAjout = rs.getTimestamp("dateAjout");
				Timestamp dateCloture = rs.getTimestamp("dateCloture");
				String idUserToCast = rs.getString("fkUtilisateur");
				int fkUtilisateur = Integer.parseInt(idUserToCast);
				String idCategorie = rs.getString("fkCategorie");
				int fkCategorie = Integer.parseInt(idCategorie);
				Objet objet = new Objet(id,nomObjet,descriptionObjet,prixInitial,prixAchatImmediat,dateAjout,dateCloture,fkUtilisateur,fkCategorie);
				objets.add(objet);
			}
			
			rs.close();
			stmt.close();
			c.close();
			return (objets);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}
	
	public LinkedList<Enchere> obtenirTousLesEncheres() {
		return obtenirToutesLesEncheres ( -1 )  ;
	}
	
	/**
	 * Obtention de tous les clients inscrits dans la base de données.
	 * Pour le fonctionnement en DB, voir les commentaires de la méthode "dbObtenirUnClient()"
	 * parameter ID est utiliser pour trouvé tous les encheres pour un tel produit.
	 * @param id		int
	 * @return
	 */
		
	public LinkedList<Enchere> obtenirToutesLesEncheres( int id ) {

		LinkedList<Enchere> lesEncheres = new LinkedList<Enchere>();
		Connection connectionDB = null;
		Statement requeteSQL = null;

		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
			requeteSQL = connectionDB.createStatement();
			String fk_Objet = id > 0 ? "WHERE fkObjet"+ String.valueOf(id) : ""  ;
			ResultSet resultatRequeteSQL = requeteSQL.executeQuery("SELECT * FROM Enchere " +fk_Objet+";");
//			ResultSet resultatRequeteSQL = requeteSQL.executeQuery("SELECT * FROM  Enchere ;");

			System.out.println(" TEST " ) ;
			
			while (resultatRequeteSQL.next()) {

				
				int idEnchere   = resultatRequeteSQL.getInt("idEnchere");
				int fkObjet     = resultatRequeteSQL.getInt("fkObjet");
				int participant = resultatRequeteSQL.getInt("participant");
				double montantEnchere  		 = resultatRequeteSQL.getDouble("montantEnchere") ;
				Timestamp dateEnchere = resultatRequeteSQL.getTimestamp("dateEnchere") ;
				int enchereGagnante 		 = resultatRequeteSQL.getInt("enchereGagnante");			
			
				Enchere enchere = new Enchere();
				enchere.setIdEnchere(idEnchere)   ;
				enchere.setFkObjet(fkObjet);
				enchere.setParticipant(participant);
				enchere.setMontantEnchere(montantEnchere);
				enchere.setDateEnchere(dateEnchere);
				enchere.setEnchereGagnante(enchereGagnante);

				
				lesEncheres.add(enchere);
			}
			
			resultatRequeteSQL.close();
			requeteSQL.close();
			connectionDB.close();
			return (lesEncheres);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}
	
	
	/**
	 * @return True si la méthode a eu lieu sans erreur, false sinon.
	 */
	public boolean enregistrerUneEnchere( Enchere Enchere ) {

		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
					
			
			
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Enchere (fkObjet, participant, montantEnchere, dateEnchere, enchereGagnante ) VALUES(?, ?, ?, ?, ?);");
			
			requeteSQLPreparee.setString(1, String.valueOf(  Enchere.getFkObjet() )  );
			requeteSQLPreparee.setString(2, String.valueOf(  Enchere.getParticipant() )  );
			requeteSQLPreparee.setString(3, String.valueOf(  Enchere.getMontantEnchere() )  );
			requeteSQLPreparee.setString(4, String.valueOf(  Enchere.getDateEnchere() )  );
			requeteSQLPreparee.setString(5, String.valueOf(  Enchere.getEnchereGagnante() )  );
			requeteSQLPreparee.setString(6, String.valueOf(  Enchere.getFkObjet() )  );
			
			
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la méthode executeQuery, mais cette méthode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
						
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}


}
