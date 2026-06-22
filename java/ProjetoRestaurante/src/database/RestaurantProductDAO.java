package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.RestaurantProduct;
import view.OrderItemView;
import view.RestaurantProductView;

/**
 * Class: RestaurantProductDAO
 *
 * Description:
 * DAO responsible for managing associations between global catalog products
 * and individual restaurants (many-to-many relationship).
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform data manipulations related to restaurant-product associations
 *
 * @author Rodrigo
 * @since 28-04-2026
 */

public class RestaurantProductDAO {
	
	/**
	 * Inserts a restaurant-product association into the associative table.
	 * @param conn database connection
	 * @param pr RestaurantProduct object to insert
	 * @return true if insertion succeeded, false otherwise
	 */
	public boolean associarProdutoRestaurante(Connection conn, RestaurantProduct pr) {
		String sqlQuery = "INSERT INTO PRODUTO_RESTAURANTE (" +
				"pk_fk_res_cnpj, " +
				"pk_fk_prd_codigo, " +
				"pdr_qtde_estoque, " +
				"pdr_preco) " +
				"VALUES (?, ?, ?, ?)";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, pr.getCnpjRestaurante());
			stmt.setInt(2, pr.getCodigoProduto());
			stmt.setInt(3, pr.getQuantidadeEstoque());
			stmt.setDouble(4, pr.getPreco());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO_RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves all products for a given restaurant from the database.
	 * @param conn database connection
	 * @param cnpj the restaurant's CNPJ (identifier)
	 * @return list of RestaurantProductView representing the restaurant's products
	 */
	public ArrayList<RestaurantProductView> retornarTodoProdutoRestaurante(Connection conn, String cnpj) {		
		String sqlQuery = "SELECT p.prd_nome, "
				+ "p.pk_prd_codigo,"
				+ "pr.pdr_preco, "
				+ "pr.pdr_qtde_estoque, "
				+ "p.prd_descricao "
				+ "FROM PRODUTO_RESTAURANTE AS pr "
				+ "INNER JOIN PRODUTO AS p "
				+ "ON p.pk_prd_codigo = pr.pk_fk_prd_codigo "
				+ "WHERE pk_fk_res_cnpj = ?";
		
		// list to store all restaurant product instances
		ArrayList<RestaurantProductView> listaProdutos = new ArrayList<RestaurantProductView>();
				
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, cnpj);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if there are results for products by CNPJ, add each product
			// with the result attributes to the product list
			while (resultado.next()) {
				RestaurantProductView pr = new RestaurantProductView();
				pr.setCodigoProduto(resultado.getInt("pk_prd_codigo"));
				pr.setNomeProduto(resultado.getString("prd_nome"));
				pr.setPrecoProduto(resultado.getDouble("pdr_preco"));
				pr.setQuantidadeEstoque(resultado.getInt("pdr_qtde_estoque"));
				pr.setDescricao(resultado.getString("prd_descricao"));
				
				listaProdutos.add(pr);
			}
			
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return listaProdutos;
	}
	
	/**
	 * Checks whether a product is already associated with a restaurant.
	 * @param conn database connection
	 * @param cnpj restaurant identifier
	 * @param codigo product code to check
	 * @return true if the association exists, false otherwise
	 */
	public boolean produtoJaEstaCadastrado(Connection conn, String cnpj, int codigo) {
		String sqlQuery = "SELECT * FROM PRODUTO_RESTAURANTE WHERE pk_fk_res_cnpj = ? AND pk_fk_prd_codigo = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, cnpj);
			stmt.setInt(2, codigo);
			
			ResultSet resultado = stmt.executeQuery();
			
			return resultado.next();
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Deletes a product association from a restaurant, removing it from the restaurant's catalog.
	 * @param conn database connection
	 * @param cnpj restaurant identifier
	 * @param codigo product code to delete
	 * @return true if deletion succeeded, false otherwise
	 */
	public boolean deletarProduto(Connection conn, String cnpj, int codigo) {
		String sqlQuery = "DELETE FROM PRODUTO_RESTAURANTE WHERE pk_fk_res_cnpj = ? AND pk_fk_prd_codigo = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, cnpj);
			stmt.setInt(2, codigo);
			
			// execute the query and validate success
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO_RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean atualizarProdutoRestaurante(Connection conn, RestaurantProduct pr) {
		String sqlQuery = "UPDATE PRODUTO_RESTAURANTE " +
				"SET pdr_qtde_estoque = ?, " +
				"pdr_preco = ? " +
				"WHERE pk_fk_res_cnpj = ? "
				+ "AND pk_fk_prd_codigo = ?";

		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
		
			// bind attributes to the prepared query
			stmt.setInt(1, pr.getQuantidadeEstoque());
			stmt.setDouble(2, pr.getPreco());
			stmt.setString(3, pr.getCnpjRestaurante());
			stmt.setInt(4, pr.getCodigoProduto());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
		
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO_RESTAURANTE");
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Decreases the stock of a restaurant product when an order is placed.
	 * @param conn database connection
	 * @param cnpj restaurant identifier
	 * @param item order item containing product code and quantity
	 * @return true if stock was successfully decreased, false otherwise
	 */
	public boolean diminuirEstoque(Connection conn, String cnpj, OrderItemView item) {
		String sqlQuery = "UPDATE PRODUTO_RESTAURANTE " +
						  "SET pdr_qtde_estoque = pdr_qtde_estoque - ? " +
						  "WHERE pk_fk_res_cnpj = ? AND pk_fk_prd_codigo = ? AND pdr_qtde_estoque >= ?";

		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
		
			// bind attributes to the prepared query
			
			stmt.setInt(1, item.getQuantidade());
			stmt.setString(2, cnpj);
			stmt.setInt(3, item.getCodigoProduto());
			stmt.setInt(4, item.getQuantidade());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
			e.printStackTrace();
			}
		
		return false;
	}
	
}
