package entities;

public class Usuario {
	protected String cpf;
	protected String primeiroNome;
	protected String nomeMeio;
	protected String ultimoNome;
	protected String telefone;
	
	protected Usuario(String cpf, String primeiroNome, String nomeMeio, String ultimoNome, String telefone) {
		this.cpf = cpf;
		this.primeiroNome = primeiroNome;
		this.nomeMeio = nomeMeio;
		this.ultimoNome = ultimoNome;
		this.telefone = telefone;
	}
	
	protected Usuario() {
		
	}

	/**
	 * 
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * 
	 * @param primeiroNome
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	/**
	 * 
	 * @return
	 */
	public String getNomeMeio() {
		return nomeMeio;
	}
	
	/**
	 * 
	 * @param nomeMeio
	 */
	public void setNomeMeio(String nomeMeio) {
		this.nomeMeio = nomeMeio;
	}

	/**
	 * 
	 * @return
	 */
	public String getUltimoNome() {
		return ultimoNome;
	}

	/**
	 * 
	 * @param ultimoNome
	 */
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	
	
}
