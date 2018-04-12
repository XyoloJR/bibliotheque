package org.appli;

public class Livre {
	private int id;
	private String titre;
	private int annee;
	private String auteur;
	private String editeur;

	public Livre(int id, String titre, int annee, String auteur, String editeur) {
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.auteur = auteur;
		this.editeur = editeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + ", " + titre + ", " + annee + ", " + auteur + ", " + editeur;
	}
}
