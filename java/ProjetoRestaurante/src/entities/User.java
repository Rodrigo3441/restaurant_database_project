package entities;

/**
 * Abstract Class: User
 *
 * Description:
 * Represents a base entity for system users.
 *
 * Responsibilities:
 * - Store users' personal information
 * - Define common attributes shared by subclasses
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public abstract class User {
	protected String cpf;
	protected String primeiroNome;
	protected String nomeMeio;
	protected String ultimoNome;
	protected String telefone;
	
	// No-argument constructor
	protected User() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getNomeMeio() {
		return nomeMeio;
	}

	public void setNomeMeio(String nomeMeio) {
		this.nomeMeio = nomeMeio;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	
	
}
