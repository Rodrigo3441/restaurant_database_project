package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.OrderItem;
import view.OrderItemView;

/**
 * Class: OrderItemDAO
 *
 * Description:
 * Responsible for managing the association between the restaurant's product
 * catalog and each order (many-to-many relationship).
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform data operations for order items
 *
 * @author Rodrigo
 * @since 07-05-2026
 */

public class OrderItemDAO {
	
	/**
	 * Inserts a customer order item into the database.
	 * @param conn database connection
	 * @param ip order item object
	 * @return true if insert succeeded, false otherwise
	 */
	public boolean inserirItemPedido(Connection conn, OrderItem ip) {
		String sqlQuery = "INSERT INTO ITEM_PEDIDO ("
						+ "pk_fk_ped_numero, "
						+ "pk_fk_prd_codigo, "
						+ "itp_quantidade) VALUES "
						+ "(?, ?, ?)";
		
			// prepare the statement before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
				// bind attributes to the prepared statement
			stmt.setInt(1, ip.getNumeroPedido());
			stmt.setInt(2, ip.getCodigoProduto());
			stmt.setInt(3, ip.getQuantidade());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ITEM_PEDIDO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Returns all items for a given order for display in the customer menu.
	 * @param conn database connection
	 * @param codigoPedido order identifier
	 * @return ArrayList of OrderItemView
	 */
	public ArrayList<OrderItemView> retornarItensPedido(Connection conn, int codigoPedido) {		
		String sqlQuery = "SELECT "
						+ "p.prd_nome, "
						+ "ip.itp_quantidade, "
						+ "pr.pdr_preco "
						+ "FROM ITEM_PEDIDO AS ip "
						+ "INNER JOIN PRODUTO AS p "
						+ "ON ip.pk_fk_prd_codigo = p.pk_prd_codigo "
						+ "INNER JOIN PRODUTO_RESTAURANTE AS pr "
						+ "ON p.pk_prd_codigo = pr.pk_fk_prd_codigo "
						+ "WHERE ip.pk_fk_ped_numero = ?;";
		
		// List to store all order item view instances
		ArrayList<OrderItemView> listaItemPedido = new ArrayList<OrderItemView>();
				
		// prepare the statement before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared statement
			stmt.setInt(1, codigoPedido);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				OrderItemView ip = new OrderItemView();
				ip.setNome(resultado.getString("prd_nome"));
				ip.setPreco(resultado.getDouble("pdr_preco"));
				ip.setQuantidade(resultado.getInt("itp_quantidade"));
				
				listaItemPedido.add(ip);
			}
			
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return listaItemPedido;
	}
}
