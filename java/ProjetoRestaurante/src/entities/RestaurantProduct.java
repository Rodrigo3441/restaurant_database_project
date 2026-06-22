package entities;

/**
 * Entity: RestaurantProduct
 *
 * Description:
 * Represents a product offered by a restaurant in the system.
 *
 * Responsibilities:
 * - Link products to restaurants
 * - Store product pricing information
 * - Track available stock quantity
 * - Identify products sold by the restaurant
 *
 * Author: Rodrigo
 * Since: 2026-04-20
 */

public class RestaurantProduct {
	private String cnpjRestaurante;
	private Integer codigoProduto;
	private Integer quantidadeEstoque;
	private Double preco;
	
	
	// No-argument constructor
	public RestaurantProduct() {
		
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
