package entities;

public class Entregador extends Usuario {
	private String veiculo;
	private Short disponibilidade;
	
	/**
	 * Construtor com argumentos
	 * @param cpf
	 * @param primeiroNome
	 * @param nomeMeio
	 * @param ultimoNome
	 * @param telefone
	 * @param veiculo
	 * @param disponibilidade
	 */
	public Entregador(String cpf, String primeiroNome, String nomeMeio, String ultimoNome, String telefone,
			String veiculo, Short disponibilidade) {
		super(cpf, primeiroNome, nomeMeio, ultimoNome, telefone);
		this.veiculo = veiculo;
		this.disponibilidade = disponibilidade;
	}
	
	/**
	 * Construtor sem argumentos
	 */
	public Entregador() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public String getVeiculo() {
		return veiculo;
	}

	/**
	 * 
	 * @param veiculo
	 */
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * 
	 * @return
	 */
	public short getDisponibilidade() {
		return disponibilidade;
	}	
	
	/**
	 * 
	 * @return
	 */
	public String getDisponibilidadeString() {
		return (this.disponibilidade == 0) ? "Livre" : "Ocupado";
	}

	/**
	 * 
	 * @param disponibilidade
	 */
	public void setDisponibilidade(Short disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return String.format("Nome Completo: %s %s %s | "
							+ "CPF: %s | "
							+ "Telefone: %s | "
							+ "Veículo: %s | "
							+ "Disponibilidade: %s", 
							primeiroNome, 
							nomeMeio, 
							ultimoNome, 
							cpf,
							telefone, 
							veiculo, 
							this.getDisponibilidadeString());
		
	}
	
	
	
}
