package org.appli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionMySQL {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost/bibliotheque";
	private final static String login = "root";
	private final static String password = "";
	private final static String AddLivreRequest = "INSERT INTO livre (titre, annee, auteur, editeur)"
			+ "VALUES (?,?,?,?)";

	public void connect() throws ClassNotFoundException, FileNotFoundException, IOException {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
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

	public void init() {
		ScriptRunner runner = new ScriptRunner(connection, false, false);
		try {
			runner.runScript(new BufferedReader(new FileReader("../src/main/resources/bibliotheque.sql")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addLivre(Livre livre) {
		PreparedStatement stmtLivre;
		try {
			stmtLivre = connection.prepareStatement(AddLivreRequest);
			// Remplir la requête
			stmtLivre.setString(1, livre.getTitre());
			stmtLivre.setInt(2, livre.getAnnee());
			stmtLivre.setString(3, livre.getAuteur());
			stmtLivre.setString(4, livre.getEditeur());
			stmtLivre.executeUpdate();
			stmtLivre.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}