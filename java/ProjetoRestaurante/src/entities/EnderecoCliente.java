package entities;

public class EnderecoCliente extends Endereco {
	private String cpfCliente;

	/**
	 * Construtor com arugmentos
	 * @param cep
	 * @param nomeRua
	 * @param numeroRua
	 * @param cpfCliente
	 */
	public EnderecoCliente(String cep, String nomeRua, Integer numeroRua, String cpfCliente) {
		super(cep, nomeRua, numeroRua);
		this.cpfCliente = cpfCliente;
	}
	
	/**
	 * Construtor sem argumentos
	 * 
	 */
	public EnderecoCliente() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public String getCpfCliente() {
		return cpfCliente;
	}

	/**
	 * 
	 * @param cpfCliente
	 */
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	

}
