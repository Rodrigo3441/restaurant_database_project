package entities;

public class EnderecoCliente extends Endereco {
	private String cpfCliente;

	public EnderecoCliente(String cep, String nomeRua, Integer numeroRua, String cpfCliente) {
		super(cep, nomeRua, numeroRua);
		this.cpfCliente = cpfCliente;
	}

}
