package org.appli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionMySQL {
	private Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost/bibliotheque";
	private final static String login = "root";
	private final static String password = "";
	private final static String AddLivreRequest = "INSERT INTO livre (titre, annee, auteur, editeur)"
			+ "VALUES (?,?,?,?)";

	private final static String GetEmpruntsRequest = "SELECT * " + "FROM emprunt " + "WHERE date_retour IS NULL "
			+ "ORDER BY date_emprunt DESC ";
	private final static String GetLivresRequest = "SELECT * " + "FROM livre";

	private final static String AddEmpruntRequest = "INSERT INTO emprunt (livre_id, usager, date_emprunt)"
			+ "VALUES (?,?,?)";

	private final static String UpdateEmpruntRequest = "UPDATE emprunt SET date_retour = ? WHERE id = ?";

	private final static String GetLivresDispoRequest = "SELECT *"
			+ "FROM livre WHERE id NOT IN (SELECT livre_id FROM emprunt)";

	public void testConnect() throws ClassNotFoundException, FileNotFoundException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

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
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public void addLivre(Livre livre) {
		PreparedStatement stmtLivre;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public void addEmprunt(Emprunt emprunt) {
		PreparedStatement stmtEmprunt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

			stmtEmprunt = connection.prepareStatement(AddEmpruntRequest);
			// Remplir la requête
			stmtEmprunt.setInt(1, emprunt.getLivreId());
			stmtEmprunt.setString(2, emprunt.getUsager());
			stmtEmprunt.setDate(3, emprunt.getDateEmprunt());
			stmtEmprunt.executeUpdate();
			stmtEmprunt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public void updateEmprunt(Emprunt emprunt, Date dateRetour) {
		PreparedStatement stmtEmprunt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");

			stmtEmprunt = connection.prepareStatement(UpdateEmpruntRequest);
			// Remplir la requête
			stmtEmprunt.setDate(1, dateRetour);
			stmtEmprunt.setInt(2, emprunt.getId());
			stmtEmprunt.executeUpdate();
			stmtEmprunt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public ArrayList<Emprunt> getEmprunts() {
		ArrayList<Emprunt> list = new ArrayList<Emprunt>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
			Statement stmtEmprunts = connection.createStatement();
			// Remplir la requête
			ResultSet rs = stmtEmprunts.executeQuery(GetEmpruntsRequest);
			while (rs.next()) {
				Emprunt emprunt = new Emprunt(rs.getInt("id"), rs.getInt("livre_id"), rs.getString("usager"),
						rs.getDate("date_emprunt"));
				emprunt.setDateRetour(rs.getDate("date_retour"));
				list.add(emprunt);
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		return list;
	}

	public ArrayList<Livre> getLivres() {
		ArrayList<Livre> list = new ArrayList<Livre>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
			Statement stmtEmprunts = connection.createStatement();
			// Remplir la requête
			ResultSet rs = stmtEmprunts.executeQuery(GetLivresRequest);
			while (rs.next()) {
				Livre livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getInt("annee"),
						rs.getString("auteur"), rs.getString("editeur"));
				list.add(livre);
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		return list;
	}

	public ArrayList<Livre> getLivresDispo() {
		ArrayList<Livre> list = new ArrayList<Livre>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// La connexion
			connection = DriverManager.getConnection(URL, login, password);
			System.out.println("connection à la base réussie");
			Statement stmtEmprunts = connection.createStatement();
			// Remplir la requête
			ResultSet rs = stmtEmprunts.executeQuery(GetLivresDispoRequest);
			while (rs.next()) {
				Livre livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getInt("annee"),
						rs.getString("auteur"), rs.getString("editeur"));
				list.add(livre);
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		return list;
	}
}