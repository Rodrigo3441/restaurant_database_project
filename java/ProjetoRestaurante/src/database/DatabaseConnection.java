package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe: DatabaseConnection
 *
 * Descrição:
 * Classe responsável por gerenciar a conexão com o banco de dados
 *
 * Responsabilidades:
 * - Conectar ao banco de dados
 * - Tratar exceção em caso de falha na conexão
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class DatabaseConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/Fred_Food";
	private static final String USER = "postgres";
	private static final String PASSWORD = "root";
	
	/**
	 * obtém uma conexão com o banco de dados
	 * 
	 * @return objeto Connection
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch	(SQLException e){
				throw new RuntimeException("Erro ao conectar no banco de dados", e);
		}
	}
}
