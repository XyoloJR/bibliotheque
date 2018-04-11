package org.appli;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IHM {

	private JFrame frame;
	private JTextField textFieldTitre;
	private JTextField textFieldEditeur;
	private JTextField textFieldAnnee;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldLivreID;
	private JTextField textFieldUsager;
	private JTextField textFieldDateEmprunt;
	private JButton btnUpdateEmprunts;
	private JButton btnAjoutLivre;
	private JList<String> listEmprunts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM window = new IHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 562);
		frame.getContentPane().add(tabbedPane);

		JPanel TabLivre = new JPanel();
		tabbedPane.addTab("Ajouter un Livre", null, TabLivre, null);
		tabbedPane.setEnabledAt(0, true);
		TabLivre.setLayout(null);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setBounds(32, 60, 100, 20);
		TabLivre.add(lblTitre);

		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(136, 60, 86, 20);
		TabLivre.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditeur.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEditeur.setBounds(478, 60, 100, 20);
		TabLivre.add(lblEditeur);

		textFieldEditeur = new JTextField();
		textFieldEditeur.setColumns(10);
		textFieldEditeur.setBounds(582, 60, 86, 20);
		TabLivre.add(textFieldEditeur);

		JLabel lblAnnee = new JLabel("Année");
		lblAnnee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAnnee.setBounds(478, 279, 100, 20);
		TabLivre.add(lblAnnee);

		textFieldAnnee = new JTextField();
		textFieldAnnee.setColumns(10);
		textFieldAnnee.setBounds(582, 279, 86, 20);
		TabLivre.add(textFieldAnnee);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAuteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuteur.setBounds(65, 193, 206, 33);
		TabLivre.add(lblAuteur);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNom.setBounds(54, 248, 100, 20);
		TabLivre.add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(64, 279, 86, 20);
		TabLivre.add(textFieldNom);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrenom.setBounds(175, 248, 100, 20);
		TabLivre.add(lblPrenom);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(185, 279, 86, 20);
		TabLivre.add(textFieldPrenom);

		btnAjoutLivre = new JButton("Enregistrer");
		btnAjoutLivre.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAjoutLivre.setBounds(250, 426, 236, 73);
		TabLivre.add(btnAjoutLivre);

		JPanel TabEmprunt = new JPanel();
		tabbedPane.addTab("Gestion des Emprunts", null, TabEmprunt, null);
		TabEmprunt.setLayout(null);

		listEmprunts = new JList();
		listEmprunts.setBounds(10, 149, 759, 336);
		TabEmprunt.add(listEmprunts);

		btnUpdateEmprunts = new JButton("Enregistrer");
		btnUpdateEmprunts.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdateEmprunts.setBounds(10, 492, 759, 31);
		TabEmprunt.add(btnUpdateEmprunts);

		JLabel lblIdDuLivre = new JLabel("ID du Livre");
		lblIdDuLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdDuLivre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIdDuLivre.setBounds(10, 47, 127, 20);
		TabEmprunt.add(lblIdDuLivre);

		textFieldLivreID = new JTextField();
		textFieldLivreID.setColumns(10);
		textFieldLivreID.setBounds(141, 47, 179, 20);
		TabEmprunt.add(textFieldLivreID);

		JLabel labelUsager = new JLabel("Usager");
		labelUsager.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsager.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelUsager.setBounds(10, 91, 127, 20);
		TabEmprunt.add(labelUsager);

		textFieldUsager = new JTextField();
		textFieldUsager.setColumns(10);
		textFieldUsager.setBounds(141, 91, 179, 20);
		TabEmprunt.add(textFieldUsager);

		textFieldDateEmprunt = new JTextField();
		textFieldDateEmprunt.setColumns(10);
		textFieldDateEmprunt.setBounds(553, 47, 186, 20);
		TabEmprunt.add(textFieldDateEmprunt);

		JLabel labelDateEmprunt = new JLabel("Date d'emprunt");
		labelDateEmprunt.setHorizontalAlignment(SwingConstants.CENTER);
		labelDateEmprunt.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelDateEmprunt.setBounds(386, 47, 163, 20);
		TabEmprunt.add(labelDateEmprunt);
	}
}
