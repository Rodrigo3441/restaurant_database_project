package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Entity: Order
 *
 * Description:
 * Represents an order placed by a customer in the system.
 *
 * Responsibilities:
 * - Store general order information
 * - Associate customer, restaurant and delivery person with the order
 * - Track the order status
 * - Record the date and time when the order was placed
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class Order {
	private Integer numeroPedido;
	private String status;
	private String cpfEntregador;
	private String cnpjRestaurante;
	private String cpfCliente;
	private LocalDateTime dataPedido;
	
	/**
	 * No-argument constructor
	 */
	public Order() {
		
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the delivery person's CPF for the order.
	 * If no delivery person is assigned, returns a default message.
	 *
	 * @return delivery person's CPF or a message indicating no delivery person assigned
	 */
	public String getCpfEntregador() {
		if (cpfEntregador == null) {
			return "Sem entregador atribuido";
		}
		
		return cpfEntregador;
	}
	
	public void setCpfEntregador(String cpfEntregador) {
		this.cpfEntregador = cpfEntregador;
	}

	public String getCnpjRestaurante() {
		return cnpjRestaurante;
	}

	public void setCnpjRestaurante(String cnpjRestaurante) {
		this.cnpjRestaurante = cnpjRestaurante;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public String getDataPedido() {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
	    return dataPedido.format(formatoData);
	}	
	
	public void setDataPedido(LocalDateTime dataPedido) {
	    this.dataPedido = dataPedido;
	}
	
	@Override
	public String toString() {
		return " Número do pedido: " + numeroPedido +
			   " |Status: " + status +
		       " | Entregador atribuido: " + this.getCpfEntregador() +
		       " | Cliente: " + cpfCliente +
		       " | Data do pedido: " + this.getDataPedido();
	}
}
