package application;

import java.sql.Connection;
import database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("TEste");
		
	try {
		Connection conn = DatabaseConnection.getConnection();
		
		String sql = "SELECT * FROM CLIENTE";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("Cliente: " + rs.getString("cli_primeiro_nome"));
		}
		
		
		System.out.println("Connected successfully!");
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}


}
