package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Customer;
import entities.Order;
import entities.Restaurant;

/**
 * Class: OrderDAO
 *
 * Description:
 * DAO class responsible for managing order data.
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform CRUD operations on order records
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class OrderDAO {
	
	/**
	 * Inserts a new order into the database and returns the generated id.
	 * @param conn database connection
	 * @param r Restaurant associated with the order
	 * @param c Customer who placed the order
	 * @return generated order id, or -1 on failure
	 */
	public int inserirPedido(Connection conn, Restaurant r, Customer c) {
		String sqlQuery = "INSERT INTO PEDIDO (ped_status, "
				+ "fk_res_cnpj, "
				+ "fk_cli_cpf) "
				+ "VALUES (?, ?, ?)";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)){
			
			// bind attributes to the prepared statement
			stmt.setString(1, "Em preparo");
			stmt.setString(2, r.getCnpj());
			stmt.setString(3, c.getCpf());
			
			stmt.executeUpdate();
			
			// obtain the generated order id
			ResultSet resultado = stmt.getGeneratedKeys();
			
			if (resultado.next()) {
				return resultado.getInt(1);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return -1;
		
	}
	
	/**
	 * Retrieves order information from the database for lookup purposes.
	 * @param conn database connection
	 * @param numero order number to fetch
	 * @return Order object or null if not found
	 */
	public Order retornarPedido(Connection conn, int numero) {
		String sqlQuery = "SELECT * FROM PEDIDO WHERE pk_ped_numero = ?";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared statement
			stmt.setInt(1, numero);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if a result is found, instantiate an Order object with the result attributes
			if (resultado.next()) {
				Order p = new Order();
				
				p.setNumeroPedido(resultado.getInt("pk_ped_numero"));
				p.setStatus(resultado.getString("ped_status"));
				p.setCpfEntregador(resultado.getString("fk_etg_cpf"));
				p.setCnpjRestaurante(resultado.getString("fk_res_cnpj"));
				p.setCpfCliente(resultado.getString("fk_cli_cpf"));
				
				return p;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Updates an order record in the database.
	 * @param conn database connection
	 * @param pedido Order object with updated data
	 * @return true if update affected at least one row
	 */
	public boolean atualizarPedido(Connection conn, Order pedido) {
		String sqlQuery = "UPDATE PEDIDO " +
							"SET ped_status = ?, " +
							"fk_etg_cpf = ? " +
							"WHERE pk_ped_numero = ?";

			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared statement
			stmt.setString(1, pedido.getStatus());
			stmt.setString(2, pedido.getCpfEntregador());
			stmt.setInt(3, pedido.getNumeroPedido());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Deletes an order from the database.
	 * @param conn database connection
	 * @param numero order number to delete
	 * @return true if deletion affected at least one row
	 */
	public boolean deletarPedido(Connection conn, int numero) {
		String sqlQuery = "DELETE FROM PEDIDO WHERE pk_ped_numero = ?";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared statement
			stmt.setInt(1, numero);
			
			// execute the query and check success
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves all orders for a given restaurant filtered by status.
	 * @param conn database connection
	 * @param cnpj restaurant CNPJ
	 * @param status desired order status
	 * @return ArrayList of orders
	 */
	public ArrayList<Order> listarPedidosPorRestaurante(Connection conn, String cnpj, String status){
		
		// List to store all order instances
		ArrayList<Order> listaPedidos = new ArrayList<Order>();
		
		String sqlQuery = "SELECT * FROM PEDIDO WHERE fk_res_cnpj = ? AND ped_status = ? ORDER BY ped_data ASC";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			stmt.setString(1, cnpj);
			stmt.setString(2, status);
			
			ResultSet resultado = stmt.executeQuery();
			
			// store each found order in the dynamic list
			while (resultado.next()) {
				Order p = new Order();
				
				p.setNumeroPedido(resultado.getInt("pk_ped_numero"));
				p.setStatus(resultado.getString("ped_status"));
				p.setCpfEntregador(resultado.getString("fk_etg_cpf"));
				p.setCnpjRestaurante(resultado.getString("fk_res_cnpj"));
				p.setCpfCliente(resultado.getString("fk_cli_cpf"));
				p.setDataPedido(resultado.getTimestamp("ped_data").toLocalDateTime());
				
				listaPedidos.add(p);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return listaPedidos;
	}
	
	/**
	 * Retrieves all orders placed by a specific customer.
	 * @param conn database connection
	 * @param cpf customer CPF
	 * @return ArrayList of orders
	 */
	public ArrayList<Order> listarPedidosPorCliente(Connection conn, String cpf){
		
		// List to store all order instances
		ArrayList<Order> listaPedidos = new ArrayList<Order>();
		
		String sqlQuery = "SELECT * FROM PEDIDO WHERE fk_cli_cpf = ? ORDER BY ped_data DESC";
		
			// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			// store each found order in the dynamic list
			while (resultado.next()) {
				Order p = new Order();
				
				p.setNumeroPedido(resultado.getInt("pk_ped_numero"));
				p.setStatus(resultado.getString("ped_status"));
				p.setCpfEntregador(resultado.getString("fk_etg_cpf"));
				p.setCnpjRestaurante(resultado.getString("fk_res_cnpj"));
				p.setCpfCliente(resultado.getString("fk_cli_cpf"));
				p.setDataPedido(resultado.getTimestamp("ped_data").toLocalDateTime());
				
				listaPedidos.add(p);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return listaPedidos;
	}
}
