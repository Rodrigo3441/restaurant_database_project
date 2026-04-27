package application;

import java.sql.Connection;
import database.DatabaseConnection;

import ui.MenuPrincipal;



public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	

		Connection conn = DatabaseConnection.getConnection();
		
		MenuPrincipal mn = new MenuPrincipal(conn);
		mn.mostrar();
		
	}
}
