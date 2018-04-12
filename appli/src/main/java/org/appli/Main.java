package org.appli;

public class Main {

	public static void main(String[] args) {
		Controler controler = new Controler();
		Bibliotheque bibliotheque = controler.getBibliotheque();
		ConnectionMySQL connectionMySQL = controler.getConnection();

		bibliotheque.setEmprunts(connectionMySQL.getEmprunts());

		bibliotheque.setLivres(connectionMySQL.getLivres());
		// bibliotheque.affEmprunt();
		bibliotheque.affLivres();

		controler.addLivre("zrgserhg", 1845, "rstjj", "ghyytyj");
		bibliotheque.setLivres(connectionMySQL.getLivres());
		bibliotheque.affLivres();
	}

}
