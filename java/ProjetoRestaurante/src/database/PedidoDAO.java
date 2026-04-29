package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Pedido;

/**
 * Classe: AcessoDadosPedido
 *
 * Descrição:
 * Classe responsável por gerenciar dados do pedido
 *
 * Responsabilidades:
 * - Conectar ao banco de dados
 * - Fazer manipulações com os dados
 *
 * @author Rodrigo
 * @since 21-04-2026
 */

public class AcessoDadosPedido {
	
	private Connection conn;
	
	/**
	 * Construtor
	 * Recebe a conexão para que seja possível estabelecer
	 * uma comunicação com o banco de dados
	 * 
	 * @param conn: objeto de conexão
	 */
	public AcessoDadosPedido(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Método inserirPedido
	 * responsável por fazer a inserção de um novo pedido no banco de dados
	 * 
	 * @param pedido: objeto pedido
	 */
	public boolean inserirPedido(Pedido pedido) {
		String sqlQuery = "INSERT INTO PEDIDO (ped_status, "
				+ "fk_etg_cpf, "
				+ "fk_res_cnpj, "
				+ "fk_cli_cpf) "
				+ "VALUES (?, ?, ?, ?)";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, pedido.getStatus());
			stmt.setString(2, pedido.getCpfEntregador());
			stmt.setString(3, pedido.getCnpjRestaurante());
			stmt.setString(4, pedido.getCpfCliente());
			
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Método retornarPedido
	 * 
	 * Responsável por trazer as informações do pedido da base de dados
	 * para que possam ser utilizadas para fins de consulta
	 *  
	 * @param numero: numero do pedido buscado
	 * @return um objeto do tipo pedido
	 */
	public Pedido retornarPedido(int numero) {
		String sqlQuery = "SELECT * FROM PEDIDO WHERE pk_ped_numero = ?";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setInt(1, numero);
			
			ResultSet resultado = stmt.executeQuery();
			
			//se houver resultado da busca pelo cnpj, instancia um objeto restaurante
			//com os atributos do resultado
			if (resultado.next()) {
				Pedido p = new Pedido();
				
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
	 * Método atualizarPedido
	 * 
	 * Responsável por atualizar as informações de um pedido no banco de dados 
	 * 
	 * @param pedido: objeto do tipo pedido
	 */
	public boolean atualizarPedido(Pedido pedido) {
		String sqlQuery = "UPDATE PEDIDO " +
							"SET ped_status = ?, " +
							"fk_etg_cpf = ? " +
							"WHERE pk_ped_numero = ?";

		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
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
	 * Método deletarPedido
	 * 
	 * Responsável por apagar um pedido do banco de dados
	 * 
	 * @param numero do pedido
	 * @return true ou false
	 */
	public boolean deletarPedido(int numero) {
		String sqlQuery = "DELETE FROM PEDIDO WHERE pk_ped_numero = ?";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setInt(1, numero);
			
			//execução da query e validação de êxito
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Metódo listarPedidos
	 * 
	 * Responsável por trazer informações de todos os pedidos do sistema
	 * @return ArrayList com todos os restaurantes
	 */
	public ArrayList<Pedido> listarPedidos(){
		
		//Lista para armazenar todos as instâncias de pedido
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		String sqlQuery = "SELECT * FROM PEDIDO";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			ResultSet resultado = stmt.executeQuery();
			
			//armazenando todos os restaurantes encontrados na lista dinânica de pedidos
			while (resultado.next()) {
				Pedido p = new Pedido();
				
				p.setNumeroPedido(resultado.getInt("pk_ped_numero"));
				p.setStatus(resultado.getString("ped_status"));
				p.setCpfEntregador(resultado.getString("fk_etg_cpf"));
				p.setCnpjRestaurante(resultado.getString("fk_res_cnpj"));
				p.setCpfCliente(resultado.getString("fk_cli_cpf"));
				
				listaPedidos.add(p);
			}
			
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de PEDIDO");
		    e.printStackTrace();
		}
		
		return listaPedidos;
	}
}
