package org.appli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost/bibliotheque";
	private final static String login = "root";
	private final static String password = "";

	public void connect() throws ClassNotFoundException, FileNotFoundException, IOException {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

			ScriptRunner runner = new ScriptRunner(connection, false, false);
			runner.runScript(new BufferedReader(new FileReader("../src/main/resources/bibliotheque.sql")));

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