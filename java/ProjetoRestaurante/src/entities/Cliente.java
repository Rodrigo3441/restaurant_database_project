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
	
}
