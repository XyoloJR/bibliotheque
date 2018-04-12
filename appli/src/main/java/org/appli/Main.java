package org.appli;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		Controler controler = new Controler();
		Bibliotheque bibliotheque = controler.getBibliotheque();
		ConnectionMySQL connectionMySQL = controler.getConnection();
		// connectionMySQL.init();

		bibliotheque.setEmprunts(connectionMySQL.getEmprunts());

		controler.getIhm().setEmprunts(controler.empruntsToArray());

		bibliotheque.setLivres(connectionMySQL.getLivres());
		// bibliotheque.affEmprunts();
		bibliotheque.affLivres();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed;
		try {
			parsed = format.parse("2018-04-10");
			Date sqlDate = new Date(parsed.getTime());
			controler.addEmprunt(8, "gertrude", sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bibliotheque.affEmprunts();
		// bibliotheque.affLivres();

		bibliotheque.setLivres(connectionMySQL.getLivresDispo());
		bibliotheque.affLivres();
	}

}
