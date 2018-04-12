package org.appli;

import java.sql.Date;

public class Controler {
	private IHM ihm = new IHM();
	private ConnectionMySQL connection = new ConnectionMySQL();
	private Bibliotheque bibliotheque = new Bibliotheque();

	public void addLivre(String titre, int annee, String auteur, String editeur) {
		Livre livre = new Livre(Bibliotheque.NEW_LIVRE_ID, titre, annee, auteur, editeur);
		bibliotheque.addLivre(livre);
		connection.addLivre(livre);
	}

	public void addEmprunt(int id, int livreId, String usager, Date dateEmprunt) {
		if (bibliotheque.isDispo(livreId)) {
			Emprunt emprunt = new Emprunt(id, livreId, usager, dateEmprunt);
			bibliotheque.addEmprunt(emprunt);
		} else {
			System.out.println("livre déjà emprunté");
		}
	}

	public void rendre(Emprunt emprunt, Date dateRetour) {
		connection.updateEmprunt(emprunt, dateRetour);
		bibliotheque.supEmprunt(emprunt);
	}

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

	public ConnectionMySQL getConnection() {
		return connection;
	}

	public void setConnection(ConnectionMySQL connection) {
		this.connection = connection;
	}

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

}
