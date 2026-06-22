package entities;

/**
 * Entity: Product
 *
 * Description:
 * Represents a product registered in the system.
 *
 * Responsibilities:
 * - Store product information
 * - Maintain product identification and description
 * - Associate the product with a category
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class Product {
	private Integer codigo;
	private String nome;
	private String descricao;
	private Integer idCategoria;
	
	// No-argument constructor
	public Product() {
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

}
