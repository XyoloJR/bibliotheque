package org.appli;

import java.awt.EventQueue;
import java.sql.Date;

public class Controler {
	private IHM ihm;
	private ConnectionMySQL connection;
	private Bibliotheque bibliotheque;

	public void addLivre(String titre, int annee, String auteur, String editeur) {
		Livre livre = new Livre(Bibliotheque.NEW_LIVRE_ID, titre, annee, auteur, editeur);
		connection.addLivre(livre);
		bibliotheque.setLivres(connection.getLivres());
	}

	public void addEmprunt(int livreId, String usager, Date dateEmprunt) {
		if (bibliotheque.isDispo(livreId)) {
			Emprunt emprunt = new Emprunt(Bibliotheque.NEW_EMPRUMT_ID, livreId, usager, dateEmprunt);
			connection.addEmprunt(emprunt);
			bibliotheque.setEmprunts(connection.getEmprunts());
		} else {
			System.out.println("livre déjà emprunté");
		}
	}

	public void rendre(Emprunt emprunt, Date dateRetour) {
		connection.updateEmprunt(emprunt, dateRetour);
		bibliotheque.supEmprunt(emprunt);
	}

	public Controler() {
		connection = new ConnectionMySQL();
		bibliotheque = new Bibliotheque(connection.getLivres(), connection.getEmprunts());
		ihm = new IHM(this);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ihm.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

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

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

}
