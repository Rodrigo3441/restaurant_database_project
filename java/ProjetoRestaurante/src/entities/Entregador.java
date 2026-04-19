package entities;

public class Entregador extends Usuario {
	private String veiculo;
	private Short disponibilidade;
	
	public Entregador(String cpf, String primeiroNome, String nomeMeio, String ultimoNome, String telefone,
			String veiculo, Short disponibilidade) {
		super(cpf, primeiroNome, nomeMeio, ultimoNome, telefone);
		this.veiculo = veiculo;
		this.disponibilidade = disponibilidade;
	}
	
	
}
