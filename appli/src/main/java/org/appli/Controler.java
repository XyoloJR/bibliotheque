package org.appli;

public class Controler {
	private IHM ihm = new IHM();
	private ConnectionMySQL connection = new ConnectionMySQL();
	private Bibliotheque bibliotheque = new Bibliotheque();

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

	public ConnectionMySQL getConnection() {
		return connection;
	}

	public void setConnection(ConnectionMySQL connection) {
		this.connection = connection;
	}

	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

}
