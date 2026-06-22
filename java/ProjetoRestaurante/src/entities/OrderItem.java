package entities;

/**
 * Entity: OrderItem
 *
 * Description:
 * Represents an item associated with a system order.
 *
 * Responsibilities:
 * - Store information about the product linked to the order
 * - Record the requested quantity of the product
 * - Associate products with completed orders
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class OrderItem {
	private Integer numeroPedido;
	private Integer codigoProduto;
	private Integer quantidade;
	
	
	/**
	 * No-argument constructor
	 */
	public OrderItem() {
		
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
