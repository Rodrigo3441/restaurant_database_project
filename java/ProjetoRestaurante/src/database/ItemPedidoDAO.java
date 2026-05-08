package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.ItemPedido;

/**
 * Classe: ItemPedidoDAO
 *
 * Descrição:
 * Classe responsável por gerenciar as associações de produtos do catálogo do restaurante
 * com cada pedido (N:N)
 *
 * Responsabilidades:
 * - Conectar ao banco de dados
 * - Fazer manipulações com os dados
 *
 * @author Rodrigo
 * @since 07-05-2026
 */

public class ItemPedidoDAO {
	
	/**
	 * cadastra um item do pedido dos clientes no banco de dados
	 * @param objeto de conexão
	 * @param objeto itempedido
	 * @return boolean
	 */
	public boolean inserirItemPedido(Connection conn, ItemPedido ip) {
		String sqlQuery = "INSERT INTO ITEM_PEDIDO ("
				+ "pk_fk_ped_numero, "
				+ "pk_fk_prd_codigo, "
				+ "itp_quantidade) VALUES "
				+ "(?, ?, ?)";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
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
}
