package org.appli;

import java.awt.Color;
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
		TabLivre.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter un Livre", null, TabLivre, null);
		tabbedPane.setEnabledAt(0, true);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(146, 116, 100, 20);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(250, 116, 383, 20);
		textFieldTitre.setColumns(10);

		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setBounds(146, 152, 100, 20);
		lblEditeur.setForeground(Color.WHITE);
		lblEditeur.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditeur.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldEditeur = new JTextField();
		textFieldEditeur.setBounds(250, 155, 383, 20);
		textFieldEditeur.setColumns(10);

		JLabel lblAnnee = new JLabel("Année");
		lblAnnee.setBounds(146, 193, 100, 20);
		lblAnnee.setForeground(Color.WHITE);
		lblAnnee.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnee.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(250, 196, 383, 20);
		textFieldAnnee.setColumns(10);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(146, 251, 487, 33);
		lblAuteur.setForeground(Color.WHITE);
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAuteur.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(146, 338, 100, 40);
		lblNom.setForeground(Color.WHITE);
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldNom = new JTextField();
		textFieldNom.setBounds(256, 291, 370, 40);
		textFieldNom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(146, 295, 100, 40);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(256, 340, 370, 40);
		textFieldPrenom.setColumns(10);

		btnAjoutLivre = new JButton("Enregistrer");
		btnAjoutLivre.setBounds(10, 443, 759, 80);
		btnAjoutLivre.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel labelLivre = new JLabel("Livre");
		labelLivre.setBounds(146, 67, 487, 33);
		labelLivre.setForeground(Color.WHITE);
		labelLivre.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivre.setFont(new Font("Tahoma", Font.BOLD, 20));
		TabLivre.setLayout(null);
		TabLivre.add(lblNom);
		TabLivre.add(textFieldPrenom);
		TabLivre.add(lblPrenom);
		TabLivre.add(lblAuteur);
		TabLivre.add(textFieldNom);
		TabLivre.add(textFieldEditeur);
		TabLivre.add(textFieldAnnee);
		TabLivre.add(lblAnnee);
		TabLivre.add(labelLivre);
		TabLivre.add(textFieldTitre);
		TabLivre.add(lblEditeur);
		TabLivre.add(lblTitre);
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
