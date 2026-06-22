package entities;

/**
 * Entity: Customer
 *
 * Description:
 * Represents a customer registered in the system.
 *
 * Responsibilities:
 * // Store the customer's personal information
 * // Maintain authentication and access data
 *
 * @author Rodrigo
 * @since 20-04-2026
 */
public class Customer extends User {
	private String email;
	private String senha;
    
	/**
	 * No-argument constructor
	 */
	public Customer() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
