package org.appli;

import java.util.ArrayList;
import java.util.Date;

public class Bibliotheque {
	private ArrayList<Livre> livres;
	private ArrayList<Emprunt> emprunts;

	public Bibliotheque() {
		ArrayList<Livre> livres = new ArrayList<Livre>();
		ArrayList<Emprunt> emprunts = new ArrayList<Emprunt>();
	}

	public void addLivre(String titre, int annee, String auteur, String editeur) {
	}

	public void addEmprunt(int id, int livre_id, String usager, Date date_emprunt) {
	}

	public void update() {
	}

	public void init() {
	}
}
