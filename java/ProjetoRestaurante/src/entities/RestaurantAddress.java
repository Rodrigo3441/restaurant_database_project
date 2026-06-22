package entities;

/**
 * Entity: RestaurantAddress
 *
 * Description:
 * Represents the address associated with a restaurant in the system.
 *
 * Responsibilities:
 * - Store the restaurant's address information
 * - Associate the address with the restaurant's CNPJ (tax ID)
 * - Format the address data for display
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class RestaurantAddress extends Address {
	private String cnpjRestaurante;
	
	/**
	 * No-argument constructor
	 */
	public RestaurantAddress() {
		super();
	}


	public String getCnpjRestaurante() {
		return cnpjRestaurante;
	}

	public void setCnpjRestaurante(String cnpjRestaurante) {
		this.cnpjRestaurante = cnpjRestaurante;
	}

	@Override
	public String formatarEndereco() {
		return "CEP: " + cep +
				" | Nome da rua: " + nome +
				" | Número do restaurante: " + numero;
	}

	@Override
	public String getIdentificacao() {
		return cnpjRestaurante;
	}
	
	
}
