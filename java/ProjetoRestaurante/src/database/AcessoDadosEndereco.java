package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.EnderecoCliente;
import entities.EnderecoRestaurante;

/**
 * Classe: AcessoDadosEndereco
 *
 * Descrição:
 * Classe responsável por gerenciar dados do Endereco
 *
 * Responsabilidades:
 * - Conectar ao banco de dados
 * - Fazer manipulações com os dados
 *
 * @author Rodrigo
 * @since 24-04-2026
 */

public class AcessoDadosEndereco {
	
	private Connection conn;
	
	/**
	 * Construtor
	 * Recebe a conexão para que seja possível estabelecer
	 * uma comunicação com o banco de dados
	 * 
	 * @param conn: objeto de conexão
	 */
	public AcessoDadosEndereco(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Método inserirEnderecoRestaurante
	 * 
	 * Responsável for receber um objeto de endereço do restaurante e inserir no banco de dados
	 * 
	 * @param er objeto do tipo EnderecoRestaurante
	 * @return true ou false
	 */
	public boolean inserirEnderecoRestaurante(EnderecoRestaurante er) {
		String sqlQuery = "INSERT INTO ENDERECO_RESTAURANTE "
				+ "(pk_fk_res_cnpj, "
				+ "pk_enr_cep, "
				+ "enr_nome, "
				+ "enr_numero) VALUES (?, ?, ?, ?)";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, er.getCnpjRestaurante());
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
	 * Método retornarEnderecoRestaurante
	 * 
	 * Responsável por trazer as informações do endereço do restaurante
	 * para que possam ser utilizadas ao longo da sessão
	 *  
	 * @param cnpj do restaurante
	 * @return objeto do tipo EnderecoRestaurante ou false
	 */
	public EnderecoRestaurante retornarEnderecoRestaurante(String cnpj) {
		String sqlQuery = "SELECT * FROM ENDERECO_RESTAURANTE WHERE pk_fk_res_cnpj = ?";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, cnpj);
			
			ResultSet resultado = stmt.executeQuery();
			
			//se houver resultado da busca pelo cpnj, instancia um objeto restaurante
			//com os atributos do resultado
			if (resultado.next()) {
				EnderecoRestaurante er = new EnderecoRestaurante();
				
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
	 * Método atualizarEnderecoRestaurante
	 * 
	 * Responsável por atualizar as informações do endereço de um restaurante no banco de dados 
	 * 
	 * @param er: objeto EnderecoRestaurante
	 */
	public boolean atualizarEnderecoRestaurante(EnderecoRestaurante er) {
		String sqlQuery = "UPDATE ENDERECO_RESTAURANTE SET " +
	            "pk_enr_cep = ?, " +
	            "enr_nome = ?, " +
	            "enr_numero = ? " +
	            "WHERE pk_fk_res_cnpj = ?";

		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, er.getCep());
	        stmt.setString(2, er.getNome());
	        stmt.setInt(3, er.getNumero());
	        stmt.setString(4, er.getCnpjRestaurante());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_RESTAURANTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Método inserirEnderecoCliente
	 * 
	 * Responsável for receber um objeto de endereço do cliente e inserir no banco de dados
	 * 
	 * @param ec objeto do tipo EnderecoCliente
	 * @return true ou false
	 */
	public boolean inserirEnderecoCliente(EnderecoCliente ec) {
		String sqlQuery = "INSERT INTO ENDERECO_CLIENTE "
				+ "(pk_fk_cli_cpf, "
				+ "pk_enc_cep, "
				+ "enc_nome, "
				+ "enc_numero) VALUES (?, ?, ?, ?)";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, ec.getCpfCliente());
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
	 * Método retornarEnderecoCliente
	 * 
	 * Responsável por trazer as informações do endereço do cliente
	 * para que possam ser utilizadas ao longo da sessão
	 *  
	 * @param cpf do cliente
	 * @return objeto do tipo EnderecoCliente ou false
	 */
	public EnderecoCliente retornarEnderecoCliente(String cpf) {
		String sqlQuery = "SELECT * FROM ENDERECO_CLIENTE WHERE pk_fk_cli_cpf = ?";
		
		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			//se houver resultado da busca pelo cpnj, instancia um objeto restaurante
			//com os atributos do resultado
			if (resultado.next()) {
				EnderecoCliente ec = new EnderecoCliente();
				
				ec.setCpfCliente(resultado.getString("pk_fk_cli_cpf"));
				ec.setCep(resultado.getString("pk_enc_cep"));
				ec.setNome(resultado.getString("enc_nome"));
				ec.setNumero(resultado.getInt("enc_numero"));
				
				return ec;

			}
									
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_RESTAURANTE");
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Método atualizarEnderecoCliente
	 * 
	 * Responsável por atualizar as informações do endereço de um cliente no banco de dados 
	 * 
	 * @param ec: objeto EnderecoCliente
	 */
	public boolean atualizarEnderecoCliente(EnderecoCliente ec) {
		String sqlQuery = "UPDATE ENDERECO_CLIENTE SET " +
	            "pk_enc_cep = ?, " +
	            "enc_nome = ?, " +
	            "enc_numero = ? " +
	            "WHERE pk_fk_cli_cpf = ?";

		//preparação da query antes da execução
		try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			
			//vinculação dos atributos à query preparada
			stmt.setString(1, ec.getCep());
	        stmt.setString(2, ec.getNome());
	        stmt.setInt(3, ec.getNumero());
	        stmt.setString(4, ec.getCpfCliente());
						
			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			System.err.println("Erro na operação de ENDERECO_CLIENTE");
		    e.printStackTrace();
		}
		
		return false;
	}
	
}
