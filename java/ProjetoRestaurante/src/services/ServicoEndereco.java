package services;

import database.DatabaseConnection;
import entities.EnderecoRestaurante;
import database.AcessoDadosEndereco;

/**
 * Classe: ServicoEndereco
 *
 * Descrição:
 * Super Classe responsável por originar serviços de Endereço do cliente e do restaurante
 *
 * Responsabilidades:
 * - oferecer métodos e validações da regra de negócio
 *
 * @author Rodrigo
 * @since 24-04-2026
 */

public class ServicoEndereco {
		
	private AcessoDadosEndereco dao = new AcessoDadosEndereco(DatabaseConnection.getConnection());
	
	public ServicoEndereco() {
		
	}
	
	/**
	 * 
	 * @param cep
	 * @return
	 */
	public boolean cepValido(String cep) {
		return cep.length() <= 8 && cep.matches("^[0-9]+$");
	}
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public boolean nomeValido(String nome) {
		return nome.length() <= 100 && nome.matches("^[a-zA-ZÀ-ÿ ]+$");
	}
	
	/**
	 * 
	 * @param numero
	 * @return
	 */
	public boolean numeroValido(int numero) {
		return numero >= 0;
	}
	
	/**
	 * 
	 * @param cnpj
	 * @return
	 */
	public EnderecoRestaurante retornarEnderecoRestaurante(String cnpj) {
		return dao.retornarEnderecoRestaurante(cnpj);
	}
	
	/**
	 * 
	 * @param er
	 * @return
	 */
	public boolean inserirEnderecoRestaurante(EnderecoRestaurante er) {
		return dao.inserirEnderecoRestaurante(er);
	}
	
	/**
	 * 
	 * @param er
	 * @return
	 */
	public boolean atualizarEnderecoRestaurante(EnderecoRestaurante er) {
		return dao.atualizarEnderecoRestaurante(er);
	}
}
