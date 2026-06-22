package entities;

/**
 * Entity: DeliveryPerson
 *
 * Description:
 * Represents a delivery person registered in the system.
 *
 * Responsibilities:
 * - Store personal information of the delivery person
 * - Maintain vehicle data used for deliveries
 * - Control the availability of the delivery person
 * - Display formatted information of the delivery person
 *
 * @author Rodrigo
 * @since 20-04-2026
 */

public class DeliveryPerson extends User {
	private String veiculo;
	private Short disponibilidade;
		
	/**
	 * No-argument constructor
	 */
	public DeliveryPerson() {
		super();
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public short getDisponibilidade() {
		return disponibilidade;
	}	

	/**
	 * Returns an availability message for the delivery person based on the availability index
	 * @return a string with the two possible availability statuses
	 */
	public String getDisponibilidadeString() {
		return (this.disponibilidade == 0) ? "Livre" : "Ocupado";
	}

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
