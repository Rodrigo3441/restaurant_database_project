package entities;

/**
 * Entity: Restaurant
 *
 * Description:
 * Represents a restaurant registered in the system.
 *
 * Responsibilities:
 * - Store restaurant information
 * - Maintain the restaurant's contact details
 * - Associate the restaurant with a category
 * - Manage authentication and access data
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class Restaurant {
	private String cnpj;
	private String nome;
	private String telefone;
	private Integer idCategoria;
	private String senha;
	
	// No-argument constructor
	public Restaurant() {
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
