package org.appli;

import java.util.ArrayList;

public class Bibliotheque {

	public static int NEW_LIVRE_ID = -1;
	public static int NEW_EMPRUMT_ID = -1;
	private ArrayList<Livre> livres;
	private ArrayList<Emprunt> emprunts;

	public Bibliotheque() {
		ArrayList<Livre> livres = new ArrayList<Livre>();
		ArrayList<Emprunt> emprunts = new ArrayList<Emprunt>();
	}

	public Bibliotheque(ArrayList<Livre> livres, ArrayList<Emprunt> emprunts) {
		super();
		this.livres = livres;
		this.emprunts = emprunts;
	}

	public void addLivre(Livre livre) {
		livres.add(livre);
	}

	public boolean isDispo(int livreId) {
		boolean reponse = true;
		int empruntId = 0;
		while (empruntId < emprunts.size() && reponse) {
			if (emprunts.get(empruntId).getLivreId() == livreId) {
				reponse = false;
			}
			empruntId++;
		}
		return reponse;
	}

	public void addEmprunt(Emprunt emprunt) {
		emprunts.add(emprunt);

	}

	public void supEmprunt(Emprunt emprunt) {
		emprunts.remove(emprunt);
	}

	public void affLivres() {
		for (Livre livre : livres) {
			System.out.println(livre);
		}
	}

	public void affEmprunts() {
		for (Emprunt emprunt : emprunts) {
			System.out.println(emprunt);
		}
	}

	public ArrayList<Livre> getLivres() {
		return livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		this.livres = livres;
	}

	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
