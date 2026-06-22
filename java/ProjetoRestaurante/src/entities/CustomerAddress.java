package entities;

/**
 * Entity: CustomerAddress
 *
 * Description:
 * Represents an address associated with a system customer.
 *
 * Responsibilities:
 * - Store the customer's address information
 * - Associate the address with the customer's CPF identifier
 * - Format address data for display
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class CustomerAddress extends Address {
	private String cpfCliente;
	
	/**
	 * No-argument constructor
	 */
	public CustomerAddress() {
		super();
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	@Override
	public String formatarEndereco() {
		return "CEP: " + cep +
				" | Nome da rua: " + nome +
				" | Número do cliente: " + numero;
	}

	@Override
	public String getIdentificacao() {
		return cpfCliente;
	}
	
	

}
