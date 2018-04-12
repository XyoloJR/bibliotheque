package org.appli;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Controler controler = new Controler();
		Bibliotheque bibliotheque = controler.getBibliotheque();
		ConnectionMySQL connectionMySQL = controler.getConnection();
		// connectionMySQL.init();

		bibliotheque.setEmprunts(connectionMySQL.getEmprunts());

		ArrayList<Emprunt> emprunts = bibliotheque.getEmprunts();
		Object[][] tabEmprunts = new Object[emprunts.size()][4];
		for (int i = 0; i < emprunts.size(); i++) {
			Emprunt emprunt = emprunts.get(i);
			tabEmprunts[i][0] = emprunt.getId();
			tabEmprunts[i][1] = emprunt.getLivreId();
			tabEmprunts[i][2] = emprunt.getUsager();
			tabEmprunts[i][3] = emprunt.getDateEmprunt();
		}

		controler.getIhm().emprunts = tabEmprunts;

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
