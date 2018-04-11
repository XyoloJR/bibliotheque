package org.appli;

import java.util.Date;

public class Emprunt {
	private int id;
	private int livreId;
	private String usager;
	private Date dateEmprunt;
	private Date dateRetour;

	public Emprunt(int id, int livre_id, String usager, Date date_emprunt) {
		this.id = id;
		livreId = livre_id;
		this.usager = usager;
		dateEmprunt = date_emprunt;
	}

	public void rendre(Date date_retour) {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLivreId() {
		return livreId;
	}

	public void setLivreId(int livreId) {
		this.livreId = livreId;
	}

	public String getUsager() {
		return usager;
	}

	public void setUsager(String usager) {
		this.usager = usager;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

}
