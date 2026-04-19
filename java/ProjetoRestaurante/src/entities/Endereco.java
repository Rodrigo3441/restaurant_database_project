package entities;

public class Endereco {
	protected String cep;
	protected String nomeRua;
	protected Integer numeroRua;
	
	
	protected Endereco(String cep, String nomeRua, Integer numeroRua) {
		this.cep = cep;
		this.nomeRua = nomeRua;
		this.numeroRua = numeroRua;
	}
	
}
