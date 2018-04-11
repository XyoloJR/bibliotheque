package org.appli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql:localhost/bibliotheque";

	public void connect() {

		try {
			// La connexion
			connection = DriverManager.getConnection(URL);
			System.out.println("connection à la base réussie");

			/*
			 * stmtJoueur = con.prepareStatement(QUERY_SAVE_JOUEUR);
			 * // Remplir la requête
			 * JoueurBean joueurBean = partieBean.getJ1();
			 * stmtJoueur.setString(1, joueurBean.getPrenom());
			 * stmtJoueur.setInt(2, joueurBean.getScorePartie());
			 * stmtJoueur.setBoolean(3, joueurBean.isTricheur());
			 * 
			 * // Lancer la requête
			 * stmtJoueur.executeUpdate();
			 * stmtJoueur.close();
			 */

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			// On ferme la connexion
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}