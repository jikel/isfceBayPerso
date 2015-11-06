/**
 * @author william
 *
 */

package uc;

import dal.DBOperations;
import launcher.Launcher;
import model.* ;

import java.sql.Date;
import java.sql.Timestamp;
// import java.text.SimpleDateFormat;
import java.util.LinkedList;


	

public class GestionEncheresImpl implements GestionEncheres {

	private Launcher launcher;
	DBOperations db;
	
	public GestionEncheresImpl(Launcher l){
		this.launcher=l;
		
		// C'est gr�ce � cet objet qu'on pourra acc�der � la DB.
		db = launcher.getDBOperations() ;
		
	}
	
	
	public  boolean ajouterEnchere( Enchere enchere ) {

		boolean resultatAjoutEnchereEnDB = db.enregistrerUneEnchere(enchere);
		return resultatAjoutEnchereEnDB;
		
	}
	
	
	/**
	 * Cette fonctionnalit� est lanc�e par l'IHM, cr�e un objet Enchere, puis donne l'ordre
	 * � la DB d'enregistrer cet Encheret en DB.
	 * @param fkObjet 			int
	 * @param participant		int
	 * @param montantEnchere	double
	 * @param dataEnchere		SimpleDateFormat
	 * @param enchereGagnante	int
	 * @return True sera retourn� si on a pu ajouter l Enchere, false en cas d'�chec.
	 */
	public boolean ajouterEnchere( int fkObjet, int participant, double montantEnchere, Timestamp dateEnchere, int enchereGagnante        ) {
		if ((fkObjet < 1) || ( participant < 1) || (montantEnchere < 0 ) || (enchereGagnante < 0)) {
			return false;
		}


		if (dateEnchere == null) {
			return false;
		}

		Enchere newEnchere = new Enchere();
		newEnchere.setFkObjet(fkObjet);
		newEnchere.setParticipant(participant);
		newEnchere.setMontantEnchere(montantEnchere);
		newEnchere.setDateEnchere(dateEnchere);
		newEnchere.setEnchereGagnante(enchereGagnante);
		
		return ajouterEnchere( newEnchere ) ;
	}	
	
	
	/**
	 * Cette fonctionnalit� est lanc�e par l'IHM, elle demande � la DB la liste des clients,
	 * puis la fournit � la couche IHM.
	 * @return La liste des clients provenant de la DB, et enregistr�e sous forme d'objets Client.
	 */
	public LinkedList<Enchere> voirEncheres(){
		LinkedList<Enchere> lesEncheres = db.obtenirTousLesEncheres();
		return lesEncheres;
	}


	@Override
	public LinkedList<Enchere> voirEncheresUtilisateur(int idUtilisateur) {
		DBOperations dbOperations = launcher.getDBOperations();
		return dbOperations.getEnchereUtilisateur(idUtilisateur);
	}


	@Override
	public LinkedList<Enchere> voirEncheresObjet(int idObjet) {
		DBOperations dbOperations = launcher.getDBOperations();
		return dbOperations.getEnchereObjet(idObjet);
	}


//	@Override
//	public Enchere choisirEnchereGagnante(int idObjet) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	
	
}
