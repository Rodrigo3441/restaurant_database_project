package entities;

public class Restaurante {
	private String cnpj;
	private String nome;
	private String telefone;
	private Integer idCategoria;
	private String senha;
	
	/**
	 * 
	 * @param cnpj
	 * @param nome
	 * @param telefone
	 * @param idCategoria
	 * @param senha
	 */
	public Restaurante(String cnpj, String nome, String telefone, Integer idCategoria, String senha) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.idCategoria = idCategoria;
		this.senha = senha;
	}
	
	public Restaurante() {
		
	}

	/**
	 * 
	 * @return
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * 
	 * @param cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}

	/**
	 * 
	 * @param idCategoria
	 */
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * 
	 * @return
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
