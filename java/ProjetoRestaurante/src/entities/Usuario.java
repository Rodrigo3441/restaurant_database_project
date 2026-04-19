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
	
}
