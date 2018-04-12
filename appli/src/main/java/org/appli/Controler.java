package org.appli;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Controler {
	private IHM ihm;
	private ConnectionMySQL connection;
	private Bibliotheque bibliotheque;

	public void addLivre(String titre, int annee, String auteur, String editeur) {
		Livre livre = new Livre(Bibliotheque.NEW_LIVRE_ID, titre, annee, auteur, editeur);
		connection.addLivre(livre);
		bibliotheque.setLivres(connection.getLivres());
		JLabel lblVert = ihm.getLblVert();
		lblVert.setText("le livre " + titre + " est bien ajouté");
		lblVert.setVisible(true);

	}

	public void addEmprunt(int livreId, String usager, Date dateEmprunt) {
		if (bibliotheque.isDispo(livreId)) {
			Emprunt emprunt = new Emprunt(Bibliotheque.NEW_EMPRUNT_ID, livreId, usager, dateEmprunt);
			connection.addEmprunt(emprunt);
			bibliotheque.setEmprunts(connection.getEmprunts());
		} else {
			System.out.println("livre déjà emprunté");
		}
	}

	public void retour(JTable tableEmprunts) {
		for (int i = 0; i < tableEmprunts.getRowCount(); i++) {
			System.out.println(tableEmprunts.getValueAt(i, 4));
			if (tableEmprunts.getValueAt(i, 4) != null) {
				System.out.println(tableEmprunts.getValueAt(i, 4));
				String dateString = tableEmprunts.getValueAt(i, 4).toString();
				if (!"".equals(dateString)) {
					System.out.println(dateString);
					Date dateRetour = stringToDate(dateString);
					rendre(bibliotheque.getEmprunts().get(i), dateRetour);
					ihm.setEmprunts(empruntsToArray());

				}
			}
		}
	}

	public void rendre(Emprunt emprunt, Date dateRetour) {
		connection.updateEmprunt(emprunt, dateRetour);
		bibliotheque.setEmprunts(connection.getEmprunts());
	}

	public Object[][] empruntsToArray() {
		ArrayList<Emprunt> emprunts = bibliotheque.getEmprunts();
		Object[][] tabEmprunts = new Object[emprunts.size()][4];
		for (int i = 0; i < emprunts.size(); i++) {
			Emprunt emprunt = emprunts.get(i);
			tabEmprunts[i][0] = emprunt.getId();
			tabEmprunts[i][1] = emprunt.getLivreId();
			tabEmprunts[i][2] = emprunt.getUsager();
			tabEmprunts[i][3] = emprunt.getDateEmprunt();
		}
		return tabEmprunts;
	}

	public Date stringToDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed;
		Date sqlDate = null;
		try {
			parsed = format.parse(dateString);
			sqlDate = new Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}

	public Controler() {
		connection = new ConnectionMySQL();
		bibliotheque = new Bibliotheque(connection.getLivres(), connection.getEmprunts());
		ihm = new IHM(this);
		ihm.setEmprunts(empruntsToArray());
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
