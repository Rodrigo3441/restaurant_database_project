package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Product;

/**
 * Class: ProductDAO
 *
 * Description:
 * Data access object responsible for managing product records.
 *
 * Responsibilities:
 * - Connect to the database
 * - Perform CRUD operations on product data
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class ProductDAO {
	
	/**
	 * Inserts a new product into the database.
	 * @param conn database connection
	 * @param produto product object to insert
	 * @return true if insert succeeded, false otherwise
	 */
	public boolean inserirProduto(Connection conn, Product produto) {
		String sqlQuery = "INSERT INTO PRODUTO (" +
				"pk_prd_codigo, " +
				"prd_nome, " +
				"prd_descricao, " +
				"fk_prd_id_catg) " +
				"VALUES (?, ?, ?, ?)";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setInt(1, produto.getCodigo());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setObject(4, produto.getIdCategoria());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Retrieves a product from the database by its id.
	 * @param conn database connection
	 * @param codigo product id to search for
	 * @return Product object if found, otherwise null
	 */
	public Product retornarProdutoPorId(Connection conn, int codigo) {
		String sqlQuery = "SELECT * FROM PRODUTO WHERE pk_prd_codigo = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setInt(1, codigo);
			
			ResultSet resultado = stmt.executeQuery();
			
			// if there is a result from the search by id, instantiate a Product
			// with the attributes from the result
			if (resultado.next()) {
				Product p = new Product();
							
				p.setCodigo(resultado.getInt("pk_prd_codigo"));
				p.setNome(resultado.getString("prd_nome"));
				p.setDescricao(resultado.getString("prd_descricao"));
				
				//categoria do produto pode ser null
				int categoria = resultado.getInt("fk_prd_id_catg");
				if (!resultado.wasNull()) {
					p.setIdCategoria(categoria);
				}
				return p;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Retrieves a product from the database by matching its name.
	 * Uses SQL LIKE to perform a partial match.
	 * @param conn database connection
	 * @param nome name (or partial name) of the product to search for
	 * @return Product object if a match is found, otherwise null
	 */
	public Product retornarProdutoPorNome(Connection conn, String nome) {
		String sqlQuery = "SELECT * FROM PRODUTO WHERE prd_nome LIKE ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, "%" + nome + "%");
			
			ResultSet resultado = stmt.executeQuery();
			
			// if there is a result from the name search, instantiate a Product
			// with the attributes from the result
			if (resultado.next()) {
				Product p = new Product();
							
				p.setCodigo(resultado.getInt("pk_prd_codigo"));
				p.setNome(resultado.getString("prd_nome"));
				p.setDescricao(resultado.getString("prd_descricao"));
				
				//categoria do produto pode ser null
				int categoria = resultado.getInt("fk_prd_id_catg");
				if (!resultado.wasNull()) {
					p.setIdCategoria(categoria);
				}
				return p;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Updates an existing product's information in the database.
	 * @param conn database connection
	 * @param produto product object with updated values
	 * @return true if update succeeded, false otherwise
	 */
	public boolean atualizarProduto(Connection conn, Product produto) {
		String sqlQuery = "UPDATE PRODUTO SET "
				+ "prd_nome = ?, "
				+ "prd_descricao = ?, "
				+ "fk_prd_id_catg = ? "
				+ "WHERE pk_prd_codigo = ?";

		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setString(1, produto.getNome());
	        stmt.setString(2, produto.getDescricao());
	        stmt.setObject(3, produto.getIdCategoria());
	        stmt.setObject(4, produto.getCodigo());
	
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Deletes a product from the database by id.
	 * @param conn database connection
	 * @param codigo id of the product to delete
	 * @return true if delete succeeded, false otherwise
	 */
	public boolean deletarProduto(Connection conn, int codigo) {
		String sqlQuery = "DELETE FROM PRODUTO WHERE pk_prd_codigo = ?";
		
		// prepare the query before execution
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			// bind attributes to the prepared query
			stmt.setInt(1, codigo);
			
			// execute the query and validate success
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de PRODUTO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
}
