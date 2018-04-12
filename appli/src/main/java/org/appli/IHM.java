package org.appli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class IHM {

	private JFrame frame;
	private Controler controler;

	JTextField textFieldTitre;
	JTextField textFieldEditeur;
	JTextField textFieldAnnee;
	JTextField textFieldPrenom;
	JTextField textFieldNom;
	JTextField textFieldLivreID;
	JTextField textFieldUsager;
	JTextField textFieldDateEmprunt;

	JButton btnUpdateEmprunts = new JButton("Enregistrer");
	JButton btnAjoutLivre = new JButton("Enregistrer");

	JTable tableEmprunts;
	String[] entetes = { "ID Emprunt", "Livre", "Usager", "Date Emprunt", "Date Retour" };
	Object[][] emprunts = {};

	public Object[][] getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Object[][] emprunts) {
		this.emprunts = emprunts;
		refreshScreen();
	}

	/**
	 * Launch the application.
	 */

	///////////////
	// Actual App//
	///////////////

	public JFrame getFrame() {
		return frame;
	}

	public IHM(Controler controler) {
		this.controler = controler;
		initialize();
		refreshScreen();
	}

	//////////////////////////////////////////
	// Initialize the contents of the frame.//
	//////////////////////////////////////////
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		///////////////////////
		// Données Graphiques//
		///////////////////////

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 562);
		frame.getContentPane().add(tabbedPane);

		JPanel TabLivre = new JPanel();
		TabLivre.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter un Livre", null, TabLivre, null);
		tabbedPane.setEnabledAt(0, true);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(60, 86, 100, 40);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitre.setFont(new Font("Arial", Font.BOLD, 18));

		btnAjoutLivre = new JButton("Enregistrer");
		btnAjoutLivre.setForeground(Color.DARK_GRAY);
		btnAjoutLivre.setBackground(Color.LIGHT_GRAY);
		btnAjoutLivre.setBounds(10, 460, 760, 60);
		btnAjoutLivre.setFont(new Font("Arial", Font.BOLD, 30));

		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(160, 86, 500, 40);
		textFieldTitre.setColumns(10);

		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setBounds(60, 141, 100, 40);
		lblEditeur.setForeground(Color.WHITE);
		lblEditeur.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditeur.setFont(new Font("Arial", Font.BOLD, 18));

		textFieldEditeur = new JTextField();
		textFieldEditeur.setBounds(161, 141, 500, 40);
		textFieldEditeur.setColumns(10);

		JLabel lblAnnee = new JLabel("Année");
		lblAnnee.setBounds(60, 196, 100, 40);
		lblAnnee.setForeground(Color.WHITE);
		lblAnnee.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnee.setFont(new Font("Arial", Font.BOLD, 18));

		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(160, 196, 500, 40);
		textFieldAnnee.setColumns(10);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(186, 257, 400, 40);
		lblAuteur.setForeground(Color.WHITE);
		lblAuteur.setFont(new Font("Arial", Font.BOLD, 20));
		lblAuteur.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(60, 366, 100, 40);
		lblNom.setForeground(Color.WHITE);
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Arial", Font.BOLD, 18));

		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(160, 316, 500, 40);
		textFieldPrenom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(60, 316, 100, 40);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Arial", Font.BOLD, 18));

		textFieldNom = new JTextField();
		textFieldNom.setBounds(161, 366, 500, 40);
		textFieldNom.setColumns(10);

		btnAjoutLivre = new JButton("Enregistrer");
		btnAjoutLivre.setForeground(Color.DARK_GRAY);
		btnAjoutLivre.setBackground(Color.LIGHT_GRAY);
		btnAjoutLivre.setBounds(10, 460, 760, 60);
		btnAjoutLivre.setFont(new Font("Arial", Font.BOLD, 30));

		JLabel lblLivre = new JLabel("Livre");
		lblLivre.setBounds(186, 35, 400, 40);
		lblLivre.setForeground(Color.WHITE);
		lblLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivre.setFont(new Font("Arial", Font.BOLD, 20));
		TabLivre.setLayout(null);
		TabLivre.add(lblNom);
		TabLivre.add(textFieldNom);
		TabLivre.add(lblPrenom);
		TabLivre.add(lblAuteur);
		TabLivre.add(textFieldPrenom);
		TabLivre.add(textFieldEditeur);
		TabLivre.add(textFieldAnnee);
		TabLivre.add(lblAnnee);
		TabLivre.add(lblLivre);
		TabLivre.add(textFieldTitre);
		TabLivre.add(lblEditeur);
		TabLivre.add(lblTitre);

		TabLivre.add(btnAjoutLivre);

		JPanel TabEmprunt = new JPanel();
		TabEmprunt.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Gestion des Emprunts", null, TabEmprunt, null);
		TabEmprunt.setLayout(null);

		btnUpdateEmprunts = new JButton("Enregistrer");

		btnUpdateEmprunts.setForeground(Color.DARK_GRAY);
		btnUpdateEmprunts.setFont(new Font("Arial", Font.BOLD, 30));
		btnUpdateEmprunts.setBounds(10, 460, 760, 60);
		TabEmprunt.add(btnUpdateEmprunts);

		JLabel lblIdDuLivre = new JLabel("ID du Livre");
		lblIdDuLivre.setForeground(Color.WHITE);
		lblIdDuLivre.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdDuLivre.setFont(new Font("Arial", Font.BOLD, 18));
		lblIdDuLivre.setBounds(10, 30, 128, 40);
		TabEmprunt.add(lblIdDuLivre);

		textFieldLivreID = new JTextField();
		textFieldLivreID.setColumns(10);
		textFieldLivreID.setBounds(141, 30, 240, 40);
		TabEmprunt.add(textFieldLivreID);

		JLabel lblUsager = new JLabel("Usager");
		lblUsager.setForeground(Color.WHITE);
		lblUsager.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsager.setFont(new Font("Arial", Font.BOLD, 18));
		lblUsager.setBounds(10, 87, 128, 40);
		TabEmprunt.add(lblUsager);

		textFieldUsager = new JTextField();
		textFieldUsager.setColumns(10);
		textFieldUsager.setBounds(141, 90, 240, 40);
		TabEmprunt.add(textFieldUsager);

		textFieldDateEmprunt = new JTextField();
		textFieldDateEmprunt.setColumns(10);
		textFieldDateEmprunt.setBounds(548, 90, 221, 40);
		TabEmprunt.add(textFieldDateEmprunt);

		JLabel labelDateEmprunt = new JLabel("Date d'emprunt");
		labelDateEmprunt.setForeground(Color.WHITE);
		labelDateEmprunt.setHorizontalAlignment(SwingConstants.CENTER);
		labelDateEmprunt.setFont(new Font("Arial", Font.BOLD, 18));
		labelDateEmprunt.setBounds(391, 90, 155, 40);
		TabEmprunt.add(labelDateEmprunt);

		tableEmprunts = new JTable();
		tableEmprunts.setBorder(new LineBorder(new Color(51, 51, 51), 3, true));
		tableEmprunts.setCellSelectionEnabled(true);
		tableEmprunts.setBounds(10, 138, 759, 310);

		TabEmprunt.add(tableEmprunts);

		JLabel lblRouge = new JLabel("Livre déjà emprunté !!");
		lblRouge.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouge.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRouge.setForeground(Color.RED);
		lblRouge.setBounds(391, 11, 378, 68);
		TabEmprunt.add(lblRouge);

		/////////////
		// Boutons //
		/////////////

		// Emprunts
		btnUpdateEmprunts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int livreId = Integer.valueOf(textFieldLivreID.getText());
				String usager = textFieldUsager.getText();
				Date dateEmprunt = controler.stringToDate(textFieldDateEmprunt.getText());
				if (livreId > 0 && usager != null && dateEmprunt != null) {
					controler.addEmprunt(livreId, usager, dateEmprunt);
				} else {

				}
			}
		});
		// Ajouter un livre

		btnAjoutLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titre = textFieldTitre.getText();
				int annee = Integer.valueOf(textFieldAnnee.getText());
				String auteur = textFieldPrenom.getText() + " " + textFieldNom.getText();
				String editeur = textFieldEditeur.getText();
				if (titre != null && textFieldAnnee.getText() != null && auteur != null && editeur != null) {
					controler.addLivre(titre, annee, auteur, editeur);
					textFieldTitre.setText(null);
					textFieldEditeur.setText("");
					textFieldAnnee.setText("");
					textFieldPrenom.setText("");
					textFieldNom.setText("");

				}

			}
		});

		////////////////////////
		// Liste des Emprunts //
		////////////////////////

	}

	private void refreshScreen() {

		textFieldLivreID.setText("");
		textFieldUsager.setText("");
		textFieldDateEmprunt.setText("");
		tableEmprunts.setModel(new DefaultTableModel(emprunts,
				new String[] { "ID Emprunt", "Livre", "Usager", "Date Emprunt", "Date Retour" }));

	}
}
