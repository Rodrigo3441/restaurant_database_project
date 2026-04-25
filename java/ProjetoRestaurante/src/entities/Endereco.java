package entities;

public class Endereco {
	protected String cep;
	protected String nome;
	protected Integer numero;
	
	
	/**
	 * 
	 * @param cep
	 * @param nomeRua
	 * @param numeroRua
	 */
	protected Endereco(String cep, String nomeRua, Integer numeroRua) {
		this.cep = cep;
		this.nome = nomeRua;
		this.numero = numeroRua;
	}
	
	protected Endereco() {
		
	}

	/**
	 * 
	 * @return
	 */
	public String getCep() {
		if (cep != null) {
			return cep;
		} else {
			return "Sem cep cadastrado";
		}
	}

	/**
	 * 
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNome() {
		if (nome != null) {
			return nome;
		} else {
			return "Sem nome de rua cadastrado";
		}	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getNumero() {
		if (numero != null) {
			return numero;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}
