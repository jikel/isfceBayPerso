package uc;

import java.util.LinkedList;

import model.*;
public interface GestionEncheres {

	
	public abstract boolean ajouterEnchere( Enchere enchere ) ;
	public abstract LinkedList<Enchere> voirEncheres()  ;

}