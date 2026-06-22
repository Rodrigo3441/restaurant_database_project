  package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.DeliveryPerson;

/**
 * Class: DeliveryPersonDAO
 *
 * Description:
 * Class responsible for managing DeliveryPerson data
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform data manipulations
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class DeliveryPersonDAO {
	
	/**
	 * Responsible for inserting a new delivery person into the database
	 * @param conn connection object
	 * @param entregador delivery person object
	 * @return boolean
	 */
	public boolean inserirEntregador(Connection conn, DeliveryPerson entregador) {
		String sqlQuery = "INSERT INTO ENTREGADOR (" +
						"pk_etg_cpf, etg_primeiro_nome, " +
						"etg_nome_meio, " +
						"etg_ultimo_nome, " +
						"etg_telefone, " +
						"etg_veiculo, " +
						"etg_disponibilidade) " +
						"VALUES (?, ?, ?, ?, ?, ?, ?)";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind the attributes to the prepared query
			stmt.setString(1, entregador.getCpf());
			stmt.setString(2, entregador.getPrimeiroNome());
			stmt.setString(3, entregador.getNomeMeio());
			stmt.setString(4, entregador.getUltimoNome());
			stmt.setString(5, entregador.getTelefone());
			stmt.setString(6, entregador.getVeiculo());
			stmt.setShort(7, entregador.getDisponibilidade());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENTREGADOR");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Responsible for retrieving the delivery person's information from the database
	 * so it can be used for assigning deliveries
	 * @param conn connection object
	 * @param cpf cpf of the searched delivery person
	 * @return delivery person object
	 */
	public DeliveryPerson retornarEntregador(Connection conn, String cpf) {
		String sqlQuery = "SELECT * FROM ENTREGADOR WHERE pk_etg_cpf = ?";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind the attributes to the prepared query
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
				// if there is a result for the cpf search, instantiate a delivery person
				// object with the result attributes
			if (resultado.next()) {
				DeliveryPerson e = new DeliveryPerson();
							
				e.setCpf(resultado.getString("pk_etg_cpf"));
				e.setPrimeiroNome(resultado.getString("etg_primeiro_nome"));
				e.setNomeMeio(resultado.getString("etg_nome_meio"));
				e.setUltimoNome(resultado.getString("etg_ultimo_nome"));
				e.setTelefone(resultado.getString("etg_telefone"));
				e.setVeiculo(resultado.getString("etg_veiculo"));
				e.setDisponibilidade(resultado.getShort("etg_disponibilidade"));
				
				return e;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENTREGADOR");
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Responsible for updating a delivery person's information in the database
	 * @param conn connection object
	 * @param entregador delivery person object
	 * @return boolean
	 */
	public boolean atualizarEntregador(Connection conn, DeliveryPerson entregador) {
		String sqlQuery = "UPDATE ENTREGADOR SET " +
			            "etg_primeiro_nome = ?, " +
			            "etg_nome_meio = ?, " +
			            "etg_ultimo_nome = ?, " +
			            "etg_telefone = ?, " +
			            "etg_veiculo = ?, " +
			            "etg_disponibilidade = ? " +
			            "WHERE pk_etg_cpf = ?";

			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind the attributes to the prepared query
			stmt.setString(1, entregador.getPrimeiroNome());
	        stmt.setString(2, entregador.getNomeMeio());
	        stmt.setString(3, entregador.getUltimoNome());
	        stmt.setString(4, entregador.getTelefone());
	        stmt.setString(5, entregador.getVeiculo());
	        stmt.setShort(6, entregador.getDisponibilidade());
	        stmt.setString(7, entregador.getCpf());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENTREGADOR");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Responsible for deleting a delivery person from the database
	 * @param conn connection object
	 * @param cpf cpf of the delivery person
	 * @return boolean
	 */
	public boolean deletarEntregador(Connection conn, String cpf) {
		String sqlQuery = "DELETE FROM ENTREGADOR WHERE pk_etg_cpf = ?";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind the attributes to the prepared query
			stmt.setString(1, cpf);
			
			// query execution
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de ENTREGADOR");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Responsible for retrieving information for all delivery persons in the system
	 * @param conn connection object
	 * @return ArrayList of delivery persons
	 */
	public ArrayList<DeliveryPerson> listarEntregadores(Connection conn){
		
		// List to store all DeliveryPerson instances
		ArrayList<DeliveryPerson> listaEntregadores = new ArrayList<DeliveryPerson>();
		
		String sqlQuery = "SELECT * FROM ENTREGADOR";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			ResultSet resultado = stmt.executeQuery();
			
				// storing all found delivery persons in the dynamic list
			while (resultado.next()) {
				DeliveryPerson e = new DeliveryPerson();
		
				e.setCpf(resultado.getString("pk_etg_cpf"));
				e.setPrimeiroNome(resultado.getString("etg_primeiro_nome"));
				e.setNomeMeio(resultado.getString("etg_nome_meio"));
				e.setUltimoNome(resultado.getString("etg_ultimo_nome"));
				e.setTelefone(resultado.getString("etg_telefone"));
				e.setVeiculo(resultado.getString("etg_veiculo"));
				e.setDisponibilidade(resultado.getShort("etg_disponibilidade"));
				
				listaEntregadores.add(e);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de RESTAURANTE");
		    e.printStackTrace();
		}
		
		return listaEntregadores;
	}
	
}
