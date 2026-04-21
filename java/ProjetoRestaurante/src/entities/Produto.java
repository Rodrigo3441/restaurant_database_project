package entities;

public class Produto {
	private Integer codigo;
	private String nome;
	private String descricao;
	private Integer idCategoria;
	
	/**
	 * 
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param idCategoria
	 */
	public Produto(Integer codigo, String nome, String descricao, Integer idCategoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}
	
	public Produto() {
		
	}

	/**
	 * 
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getDescricao() {
		return descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	
	
	
}
