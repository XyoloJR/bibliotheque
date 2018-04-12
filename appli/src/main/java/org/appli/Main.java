package org.appli;

public class Main {

	public static void main(String[] args) {
		Controler controler = new Controler();
		Bibliotheque bibliotheque = controler.getBibliotheque();
		ConnectionMySQL connectionMySQL = controler.getConnection();

	}

}
