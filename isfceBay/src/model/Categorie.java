
package model;

public class Categorie {
	private int idCategorie;
	private String nomCategorie;
	
	public Categorie(int idCat,String nomCategorie) {
		this.idCategorie=idCat;
		this.nomCategorie = nomCategorie;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	

}