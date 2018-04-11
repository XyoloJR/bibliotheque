package org.appli;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldTitre = new JTextField();
		textFieldTitre.setColumns(10);

		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditeur.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldEditeur = new JTextField();
		textFieldEditeur.setColumns(10);

		JLabel lblAnnee = new JLabel("Année");
		lblAnnee.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnee.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldAnnee = new JTextField();
		textFieldAnnee.setColumns(10);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAuteur.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 18));

		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);

		btnAjoutLivre = new JButton("Enregistrer");
		btnAjoutLivre.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel labelLivre = new JLabel("Livre");
		labelLivre.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivre.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_TabLivre = new GroupLayout(TabLivre);
		gl_TabLivre.setHorizontalGroup(gl_TabLivre
				.createParallelGroup(Alignment.LEADING).addGroup(gl_TabLivre.createSequentialGroup().addGroup(
						gl_TabLivre
								.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_TabLivre
										.createSequentialGroup().addGap(32).addGroup(gl_TabLivre
												.createParallelGroup(Alignment.LEADING).addGroup(gl_TabLivre
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_TabLivre.createSequentialGroup().addGap(96)
																.addComponent(textFieldTitre, GroupLayout.DEFAULT_SIZE,
																		402, Short.MAX_VALUE))
														.addGroup(gl_TabLivre.createSequentialGroup().addGap(96)
																.addComponent(textFieldEditeur,
																		GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
														.addGroup(gl_TabLivre.createSequentialGroup().addGap(96)
																.addComponent(textFieldAnnee, GroupLayout.DEFAULT_SIZE,
																		402, Short.MAX_VALUE))
														.addGroup(Alignment.LEADING, gl_TabLivre.createSequentialGroup()
																.addGap(32)
																.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 100,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(10).addComponent(textFieldPrenom,
																		GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
														.addComponent(lblAnnee, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblEditeur, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(Alignment.LEADING, gl_TabLivre.createSequentialGroup()
																.addGap(32)
																.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE,
																		100, GroupLayout.PREFERRED_SIZE)
																.addGap(10)
																.addComponent(textFieldNom, GroupLayout.DEFAULT_SIZE,
																		356, Short.MAX_VALUE)))
												.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 100,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.LEADING,
										gl_TabLivre.createSequentialGroup().addGap(280).addComponent(btnAjoutLivre,
												GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
						.addGap(249))
				.addGroup(Alignment.TRAILING,
						gl_TabLivre.createSequentialGroup().addContainerGap(291, Short.MAX_VALUE)
								.addComponent(lblAuteur, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addGap(282))
				.addGroup(Alignment.TRAILING,
						gl_TabLivre.createSequentialGroup().addContainerGap(298, Short.MAX_VALUE)
								.addComponent(labelLivre, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addGap(275)));
		gl_TabLivre.setVerticalGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING).addGroup(gl_TabLivre
				.createSequentialGroup().addContainerGap()
				.addComponent(labelLivre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(16)
				.addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_TabLivre.createSequentialGroup()
								.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGap(16)
								.addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_TabLivre.createSequentialGroup()
												.addComponent(lblEditeur, GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)
												.addGap(12)
												.addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING)
														.addComponent(textFieldAnnee, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblAnnee, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE)))
										.addComponent(textFieldEditeur, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
				.addComponent(lblAuteur, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_TabLivre
								.createSequentialGroup().addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_TabLivre.createSequentialGroup()
												.addGap(3).addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(8)
								.addGroup(gl_TabLivre.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_TabLivre.createSequentialGroup().addGap(3).addComponent(
												textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(202).addGap(27))
						.addGroup(Alignment.TRAILING,
								gl_TabLivre.createSequentialGroup().addComponent(btnAjoutLivre,
										GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		TabLivre.setLayout(gl_TabLivre);

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
