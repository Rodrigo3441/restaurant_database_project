package entities;

/**
 * Abstract Class: Address
 *
 * Description:
 * Represents a base entity for addresses in the system.
 *
 * Responsibilities:
 * - Store common address data
 * - Define shared behaviors
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public abstract class Address {
	protected String cep;
	protected String nome;
	protected Integer numero;
	
	/**
	 * No-argument constructor
	 */
	protected Address() {
		
	}

	/**
	 * Returns the postal code (CEP) of the address.
	 * If no postal code is registered, returns a default message.
	 * 
	 * @return Postal code of the address or message indicating no postal code
	 */
	public String getCep() {
		if (cep != null) {
			return cep;
		} 
		return "Sem cep cadastrado";
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/**
	 * Returns the street name.
	 * If no street name is registered, returns a default message.
	 *
	 * @return Street name or message indicating no registration
	 */
	public String getNome() {
		if (nome != null) {
			return nome;
		} 
		return "Sem nome de rua cadastrado";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Returns the address number.
	 * If no address number is registered, returns 0.
	 *
	 * @return Address number or 0
	 */
	public Integer getNumero() {
		if (numero != null) {
			return numero;
		}
		return 0;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	/**
	 * Returns a formatted string representation of the address
	 * @return Formatted address string
	 */
	public abstract String formatarEndereco();
	
	/**
	 * Returns the identification of the owner of the address
	 * @return String with CPF/CNPJ identification
	 */
	public abstract String getIdentificacao();
	
	
}
