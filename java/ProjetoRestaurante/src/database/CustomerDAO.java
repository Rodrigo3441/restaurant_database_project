package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Customer;

/**
 * Class: ClienteDAO
 *
 * Description:
 * Manages Cliente data access and persistence.
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform CRUD operations for Cliente
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class CustomerDAO {
	
	/**
	 * Inserts a new cliente into the database.
	 * @param conn database connection
	 * @param cliente cliente object
	 */
	public boolean inserirCliente(Connection conn, Customer cliente) {
		String sqlQuery = "INSERT INTO CLIENTE (pk_cli_cpf, cli_primeiro_nome, cli_nome_meio, "
				+ "cli_ultimo_nome, cli_telefone, cli_email, cli_senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
			// prepare statement
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind parameters
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getPrimeiroNome());
			stmt.setString(3, cliente.getNomeMeio());
			stmt.setString(4, cliente.getUltimoNome());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getSenha());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves a cliente by CPF from the database.
	 * @param conn database connection
	 * @param cpf cliente CPF
	 * @return cliente object or null if not found
	 */
	public Customer retornarCliente(Connection conn, String cpf) {
		String sqlQuery = "SELECT * FROM CLIENTE WHERE pk_cli_cpf = ?";
		
			// prepare statement
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind parameters
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if a result is found, populate a Cliente object
			if (resultado.next()) {
				Customer c = new Customer();
							
				c.setCpf(resultado.getString("pk_cli_cpf"));
				c.setPrimeiroNome(resultado.getString("cli_primeiro_nome"));
				c.setNomeMeio(resultado.getString("cli_nome_meio"));
				c.setUltimoNome(resultado.getString("cli_ultimo_nome"));
				c.setTelefone(resultado.getString("cli_telefone"));
				c.setEmail(resultado.getString("cli_email"));
				c.setSenha(resultado.getString("cli_senha"));
				
				return c;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de CLIENTE");
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Updates an existing cliente's information.
	 * @param conn database connection
	 * @param cliente cliente object
	 */
	public boolean atualizarCliente(Connection conn, Customer cliente) {
		String sqlQuery = "UPDATE CLIENTE SET " +
	            "cli_primeiro_nome = ?, " +
	            "cli_nome_meio = ?, " +
	            "cli_ultimo_nome = ?, " +
	            "cli_telefone = ?, " +
	            "cli_email = ?, " +
	            "cli_senha = ? " +
	            "WHERE pk_cli_cpf = ?";

			// prepare statement
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind parameters
			stmt.setString(1, cliente.getPrimeiroNome());
	        stmt.setString(2, cliente.getNomeMeio());
	        stmt.setString(3, cliente.getUltimoNome());
	        stmt.setString(4, cliente.getTelefone());
	        stmt.setString(5, cliente.getEmail());
	        stmt.setString(6, cliente.getSenha());
	        stmt.setString(7, cliente.getCpf());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Deletes a cliente by CPF.
	 * @param conn database connection
	 * @param cpf cliente CPF
	 * @return true if deletion succeeded
	 */
	public boolean deletarCliente(Connection conn, String cpf) {
		String sqlQuery = "DELETE FROM CLIENTE WHERE pk_cli_cpf = ?";
		
			// prepare statement
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind parameters
			stmt.setString(1, cpf);
			
			// execute update and check success
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
}
