package org.appli;

import java.util.Date;

public class Emprunt {
	private int id;
	private int livre_id;
	private String usager;
	private Date date_emprunt;
	private Date date_retour = null;

	public Emprunt(int id, int livre_id, String usager, Date date_emprunt) {
		this.id = id;
		this.livre_id = livre_id;
		this.usager = usager;
		this.date_emprunt = date_emprunt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLivre_id() {
		return livre_id;
	}

	public void setLivre_id(int livre_id) {
		this.livre_id = livre_id;
	}

	public String getUsager() {
		return usager;
	}

	public void setUsager(String usager) {
		this.usager = usager;
	}

	public Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

}
