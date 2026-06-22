package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Address;
import entities.CustomerAddress;
import entities.RestaurantAddress;

/**
 * Class: EnderecoDAO
 *
 * Description:
 * Manages client and restaurant address data.
 *
 * Responsibilities:
 * - Connect to the database
 * - Manipulate address data
 *
 * @author Rodrigo
 * @since 24-04-2026
 */

public class AddressDAO {
		
	/**
	 * Inserts a restaurant address into the database.
	 * @param conn database connection
	 * @param er restaurant address object
	 * @return boolean
	 */
	public boolean inserirEnderecoRestaurante(Connection conn, Address er) {
		String sqlQuery = "INSERT INTO ENDERECO_RESTAURANTE "
				+ "(pk_fk_res_cnpj, "
				+ "pk_enr_cep, "
				+ "enr_nome, "
				+ "enr_numero) VALUES (?, ?, ?, ?)";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, er.getIdentificacao());
			stmt.setString(2, er.getCep());
			stmt.setString(3, er.getNome());
			stmt.setInt(4, er.getNumero());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves restaurant address details for use in other operations.
	 * @param conn database connection  
	 * @param cnpj restaurant CNPJ
	 * @return restaurant address object
	 */
	public RestaurantAddress retornarEnderecoRestaurante(Connection conn, String cnpj) {
		String sqlQuery = "SELECT * FROM ENDERECO_RESTAURANTE WHERE pk_fk_res_cnpj = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, cnpj);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if a result is found for the CNPJ, create a restaurant address object
			// with the result attributes
			if (resultado.next()) {
				RestaurantAddress er = new RestaurantAddress();
				
				er.setCnpjRestaurante(resultado.getString("pk_fk_res_cnpj"));
				er.setCep(resultado.getString("pk_enr_cep"));
				er.setNome(resultado.getString("enr_nome"));
				er.setNumero(resultado.getInt("enr_numero"));
				
				return er;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_RESTAURANTE");
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Updates a restaurant address in the database.
	 * @param conn database connection
	 * @param er address object
	 */
	public boolean atualizarEnderecoRestaurante(Connection conn, Address er) {
		String sqlQuery = "UPDATE ENDERECO_RESTAURANTE SET " +
	            "pk_enr_cep = ?, " +
	            "enr_nome = ?, " +
	            "enr_numero = ? " +
	            "WHERE pk_fk_res_cnpj = ?";

		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, er.getCep());
	        stmt.setString(2, er.getNome());
	        stmt.setInt(3, er.getNumero());
	        stmt.setString(4, er.getIdentificacao());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Inserts a client address into the database.
	 * @param conn database connection
	 * @param ec client address object
	 * @return boolean
	 */
	public boolean inserirEnderecoCliente(Connection conn, Address ec) {
		String sqlQuery = "INSERT INTO ENDERECO_CLIENTE "
				+ "(pk_fk_cli_cpf, "
				+ "pk_enc_cep, "
				+ "enc_nome, "
				+ "enc_numero) VALUES (?, ?, ?, ?)";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, ec.getIdentificacao());
			stmt.setString(2, ec.getCep());
			stmt.setString(3, ec.getNome());
			stmt.setInt(4, ec.getNumero());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves client address details for later use.
	 * @param conn database connection
	 * @param cpf client CPF
	 * @return client address object
	 */
	public CustomerAddress retornarEnderecoCliente(Connection conn, String cpf) {
		String sqlQuery = "SELECT * FROM ENDERECO_CLIENTE WHERE pk_fk_cli_cpf = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if a result is found for the CPF, create a client address object
			// with the result attributes
			if (resultado.next()) {
				CustomerAddress ec = new CustomerAddress();
				
				ec.setCpfCliente(resultado.getString("pk_fk_cli_cpf"));
				ec.setCep(resultado.getString("pk_enc_cep"));
				ec.setNome(resultado.getString("enc_nome"));
				ec.setNumero(resultado.getInt("enc_numero"));
				
				return ec;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_CLIENTE");
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Updates a client address in the database.
	 * @param conn database connection
	 * @param ec address object
	 * @return boolean
	 */
	public boolean atualizarEnderecoCliente(Connection conn, Address ec) {
		String sqlQuery = "UPDATE ENDERECO_CLIENTE SET " +
	            "pk_enc_cep = ?, " +
	            "enc_nome = ?, " +
	            "enc_numero = ? " +
	            "WHERE pk_fk_cli_cpf = ?";

		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, ec.getCep());
	        stmt.setString(2, ec.getNome());
	        stmt.setInt(3, ec.getNumero());
	        stmt.setString(4, ec.getIdentificacao());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
}
