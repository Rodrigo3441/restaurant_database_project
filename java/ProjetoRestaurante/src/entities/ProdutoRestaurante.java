package entities;

public class ProdutoRestaurante {
	private String cnpjRestaurante;
	private Integer codigoProduto;
	private Integer quantidadeEstoque;
	private Double preco;
	
	/**
	 * Construtor com argumentos
	 * @param restauranteCnpj do restaurante
	 * @param codigoProduto do produto
	 * @param quantidadeEstoque do produto
	 * @param preco do produto para determinado restaurante
	 */
	public ProdutoRestaurante(String cnpjRestaurante, Integer codigoProduto, Integer quantidadeEstoque, Double preco) {
		this.cnpjRestaurante = cnpjRestaurante;
		this.codigoProduto = codigoProduto;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
	}
	
	/**
	 * Construtor sem argumento
	 */
	public ProdutoRestaurante() {
		
	}

	public String getCnpjRestaurante() {
		return cnpjRestaurante;
	}

	public void setCnpjRestaurante(String cnpjRestaurante) {
		this.cnpjRestaurante = cnpjRestaurante;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	
	
}
