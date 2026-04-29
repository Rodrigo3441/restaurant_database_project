package application;

import java.sql.Connection;
import database.DatabaseConnection;

import ui.MenuPrincipal;
import ui.MenuProdutoRestaurante;



public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	

		Connection conn = DatabaseConnection.getConnection();
		
		MenuPrincipal mn = new MenuPrincipal(conn);
		mn.mostrar();
	}
}
