package services;

import database.AcessoDadosRestaurante;
import entities.Restaurante;

/**
 * Classe: ServicoRestaurante
 *
 * Descrição:
 * Classe responsável por gerenciar as regras de negócio do restaurante
 *
 * Responsabilidades:
 * - oferecer métodos de validação das informações
 * - se comunicar com a camada de dados
 *
 * @author Rodrigo
 * @since 23-04-2026
 */

public class ServicoRestaurante {
	//conexão com o banco de dados que será usada em todas as operações
	private AcessoDadosRestaurante dao;
	
	/**
	 * Construtor que recebe o objeto para conexão com a camada de dados
	 * 
	 * @param dao objeto AcessoDadosRestaurante
	 */
	public ServicoRestaurante(AcessoDadosRestaurante dao) {
		this.dao = dao;
	}
	
	/**
	 * 
	 * @param cnpj
	 * @return
	 */
	public boolean cnpjValido(String cnpj) {	
		return cnpj.length() == 14 && cnpj.matches("^[0-9]+$");
	}
	
	/**
	 * 
	 * @param cnpj
	 * @return
	 */
	public boolean cnpjDisponivel(String cnpj) {
		return dao.retornarRestaurante(cnpj) == null;
	}
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public boolean nomeValido(String nome) {
		return nome.length() >= 3 && nome.length() <= 40;
	}
	
	/**
	 * 
	 * @param telefone
	 * @return
	 */
	public boolean telefoneValido(String telefone) {
		return telefone.length() <= 11 && telefone.matches("^[0-9]+$");
	}
	
	/**
	 * 
	 * @param senha
	 * @return
	 */
	public boolean senhaValida(String senha) {
		return senha.length() < 255;
	}
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public boolean cadastrarRestaurante(Restaurante r) {
		return dao.inserirRestaurante(r);
	}
	
	/**
	 * 
	 * @param cnpj
	 * @return
	 */
	public Restaurante retornarRestaurante(String cnpj) {
		return dao.retornarRestaurante(cnpj);
	}
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public boolean atualizarRestaurante(Restaurante r) {
		return dao.atualizarRestaurante(r);
	}
	
}
