package entities;

public class EnderecoRestaurante extends Endereco {
	private String cnpjRestaurante;
	
	
	public EnderecoRestaurante(String cep, String nomeRua, Integer numeroRua, String cnpjRestaurante) {
		super(cep, nomeRua, numeroRua);
		this.cnpjRestaurante = cnpjRestaurante;
	}
	
	public EnderecoRestaurante() {
		super();
	}


	/**
	 * 
	 * @return
	 */
	public String getCnpjRestaurante() {
		return cnpjRestaurante;
	}


	/**
	 * 
	 * @param cnpjRestaurante
	 */
	public void setCnpjRestaurante(String cnpjRestaurante) {
		this.cnpjRestaurante = cnpjRestaurante;
	}
	
	
}
