package entities;

public class Cliente extends Usuario {
	private String email;
	private String senha;
	
	public Cliente(String cpf, String primeiroNome, String nomeMeio, String ultimoNome, String telefone, String email,
			String senha) {
		super(cpf, primeiroNome, nomeMeio, ultimoNome, telefone);
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
