package model;

import java.sql.Date;
import java.sql.Timestamp;



/**
 * Cette fonctionnalité  est  un objet Enchere.
 * @author william
 * @param fkObjet 			int
 * @param participant		int
 * @param montantEnchere	double
 * @param dateEnchere		SimpleDateFormat
 * @param enchereGagnante	int
 */

public class Enchere {
	
	
	private int idEnchere;
	private int fkObjet;
	private int participant;
	private double montantEnchere;
	private Timestamp dateEnchere;
	private int enchereGagnante;
	
	
	
	
	/**
	 * to manager Binds that already Exist.
	 * @param idEnchere
	 * @param fkObjet
	 * @param participant
	 * @param montantEnchere
	 * @param dateEnchere
	 * @param enchereGagnante
	 */
	public Enchere(int idEnchere, int fkObjet, int participant, double montantEnchere, Timestamp dateEnchere,
			int enchereGagnante) {
		super();
		this.idEnchere = idEnchere;
		this.fkObjet = fkObjet;
		this.participant = participant;
		this.montantEnchere = montantEnchere;
		this.dateEnchere = dateEnchere;
		this.enchereGagnante = enchereGagnante;
	}
	
	
	
	
	
	/**
	 * to Create new Binds so doesnt have a ID.
	 * @param fkObjet
	 * @param participant
	 * @param montantEnchere
	 * @param dataEnchere
	 * @param enchereGagnante
	 */
	public Enchere(int fkObjet, int participant, double montantEnchere, Timestamp dateEnchere,
			int enchereGagnante) {
		super();
		this.fkObjet = fkObjet;
		this.participant = participant;
		this.montantEnchere = montantEnchere;
		this.dateEnchere = dateEnchere;
		this.enchereGagnante = enchereGagnante;
	}





	
	public Enchere() {
		this.fkObjet = 0 ;
		this.participant = 0;
		this.montantEnchere = 0;
		this.dateEnchere =  new Timestamp ( 0 ) ;
		this.enchereGagnante = 0 ;
	}





	/**
	 * @return the idEnchere
	 */
	public int getIdEnchere() {
		return idEnchere;
	}

	/**
	 * @param idEnchere the idEnchere to set
	 */
	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}
	/**
	 * @return the fkObjet
	 */
	public int getFkObjet() {
		return fkObjet;
	}
	/**
	 * @param fkObjet the fkObjet to set
	 */
	public void setFkObjet(int fkObjet) {
		this.fkObjet = fkObjet;
	}
	

	
	
	/**
	 * @return the participant
	 */
	public int getParticipant() {
		return this.participant;
	}
	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	/**
	 * @return the montantEnchere
	 */
	public double getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(double montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	/**
	 * @return the dataEnchere
	 */
	public Timestamp getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Timestamp dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the enchereGagnante
	 */
	public int getEnchereGagnante() {
		return enchereGagnante;
	}
	/**
	 * @param enchereGagnante the enchereGagnante to set
	 */
	public void setEnchereGagnante(int enchereGagnante) {
		this.enchereGagnante = enchereGagnante;
	}


}