package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Restaurant;

/**
 * Class: RestaurantDAO
 *
 * Description:
 * DAO responsible for managing restaurant data
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform data operations
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class RestaurantDAO {
	
	/**
	 * Inserts a new restaurant into the database.
	 * @param conn database connection
	 * @param restaurante restaurant object to insert
	 * @return true if insert succeeded, false otherwise
	 */
	public boolean inserirRestaurante(Connection conn, Restaurant restaurante) {
		String sqlQuery = "INSERT INTO RESTAURANTE (pk_res_cnpj, res_nome, res_telefone, res_senha) VALUES (?, ?, ?, ?)";
		
		// preparing the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// binding attributes to the prepared statement
			stmt.setString(1, restaurante.getCnpj());
			stmt.setString(2, restaurante.getNome());
			stmt.setString(3, restaurante.getTelefone());
			stmt.setString(4, restaurante.getSenha());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves restaurant information from the database for use in operations.
	 * @param conn database connection
	 * @param cnpj CNPJ of the restaurant to retrieve
	 * @return a Restaurant object if found, otherwise null
	 */
	public Restaurant retornarRestaurante(Connection conn, String cnpj) {
		String sqlQuery = "SELECT * FROM RESTAURANTE WHERE pk_res_cnpj = ?";
		
			// preparing the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// binding attributes to the prepared statement
			stmt.setString(1, cnpj);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if there is a result for the CNPJ, instantiate a Restaurant object
			// with the attributes from the result
			if (resultado.next()) {
				Restaurant r = new Restaurant();
				
				r.setCnpj(resultado.getString("pk_res_cnpj"));
				r.setNome(resultado.getString("res_nome"));
				r.setTelefone(resultado.getString("res_telefone"));
				r.setSenha(resultado.getString("res_senha"));
				
				// restaurant category may be null
				int categoria = resultado.getInt("fk_res_id_catg");
				if (!resultado.wasNull()) {
					r.setIdCategoria(categoria);
				}
				
				return r;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Updates a restaurant's information in the database.
	 * @param conn database connection
	 * @param restaurante restaurant object with updated data
	 * @return true if update succeeded, false otherwise
	 */
	public boolean atualizarRestaurante(Connection conn, Restaurant restaurante) {
		String sqlQuery = "UPDATE RESTAURANTE " +
							"SET res_nome = ?, " +
							"res_telefone = ?, " +
							"fk_res_id_catg = ?, " +
							"res_senha = ? " +
							"WHERE pk_res_cnpj = ?";

		// preparing the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// binding attributes to the prepared statement
			stmt.setString(1, restaurante.getNome());
			stmt.setString(2, restaurante.getTelefone());
			stmt.setObject(3, restaurante.getIdCategoria());
			stmt.setString(4, restaurante.getSenha());
			stmt.setString(5, restaurante.getCnpj());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Deletes a restaurant from the database.
	 * @param conn database connection
	 * @param cnpj CNPJ of the restaurant to delete
	 * @return true if delete succeeded, false otherwise
	 */
	public boolean deletarRestaurante(Connection conn, String cnpj) {
		String sqlQuery = "DELETE FROM RESTAURANTE WHERE pk_res_cnpj = ?";
		
		// preparing the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// binding attributes to the prepared statement
			stmt.setString(1, cnpj);
			
			// execute the query and validate success
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves information for all restaurants in the system.
	 * @param conn database connection
	 * @return ArrayList of Restaurant objects
	 */
	public ArrayList<Restaurant> listarRestaurantes(Connection conn){
		
		//Lista para armazenar todos as instâncias de restaurante
		ArrayList<Restaurant> listaRestaurantes = new ArrayList<Restaurant>();
		
		String sqlQuery = "SELECT * FROM RESTAURANTE";
		
		// preparing the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			ResultSet resultado = stmt.executeQuery();
			
			// storing all found restaurants into the dynamic restaurant list
			while (resultado.next()) {
				Restaurant r = new Restaurant();
				
				r.setCnpj(resultado.getString("pk_res_cnpj"));
				r.setNome(resultado.getString("res_nome"));
				r.setTelefone(resultado.getString("res_telefone"));
				r.setIdCategoria(resultado.getInt("fk_res_id_catg"));
				r.setSenha(resultado.getString("res_senha"));
				
				listaRestaurantes.add(r);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return listaRestaurantes;
	}
}
