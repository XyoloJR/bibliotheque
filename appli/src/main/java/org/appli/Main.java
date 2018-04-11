package org.appli;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Controler controler = new Controler();

		ArrayList<Emprunt> list;
		list = controler.getConnection().getEmprunts();

	}

}
