package ui;

import java.util.Scanner;

import entities.EnderecoRestaurante;
import entities.Restaurante;
import services.ServicoEndereco;

/**
 * Classe: MenuEnderecoRestaurante
 *
 * Descrição:
 * Classe responsável por fornecer opções para o restaurante gerenciar o endereço
 *
 * Responsabilidades:
 * - fornecer interface
 * - comunicar com a camada serviço
 *
 * @author Rodrigo
 * @since 24-04-2026
 */

public class MenuEnderecoRestaurante {

	private Scanner sc = new Scanner(System.in);
	private EnderecoRestaurante endereco;
	private ServicoEndereco servicoendereco = new ServicoEndereco();
	
	
	public MenuEnderecoRestaurante() {

	}

	/**
	 * Método mostrar
	 * 
	 * Responsável por exibir a interface de endereço para o restaurante pode gerenciar
	 * tem dois estados:
	 * se o restaurante possui um endereço exibe um menu, caso contrário outro
	 * 
	 * @param r objeto restaurante
	 */
	public void mostrar(Restaurante r) {
		
		int option = 9;
		
		//armazena o endereço do restaurante
		endereco = servicoendereco.retornarEnderecoRestaurante(r.getCnpj());
		
		if (endereco == null) {
			System.out.println("Você não possue um endereço cadastrado!");
			System.out.println("O que deseja fazer?");
			System.out.println("1- Adicionar endereço");
			System.out.println("2- Voltar ao menu anterior");
			
			//escolha para menu sem endereço cadastrado 
			do {
				try {
					
					option = sc.nextInt();
					sc.nextLine();
					
					//verificar se a opção do usuário está fora do intervalo permitido
					if (!(option > 0 && option <= 2)) {
						System.out.println("Digite uma opção válida: ");
					}
				
					} catch (Exception e) {
						sc.nextLine();
						System.out.println("Digite apenas números: ");
						option = -1;
					}
			
					switch (option) {
					case 1:
						this.cadastrarEndereco(r);
						return;
					
					case 2:
						return;
					}
			
			} while (option != 2);
			
		} else {
			
			do {
				System.out.println("ENDERECO ATUAL RESTAURANTE:");
				System.out.println("CEP: " + endereco.getCep());
				System.out.println("Nome rua: " + endereco.getNome());
				System.out.println("Número do restaurante: " + endereco.getNumero());
				System.out.println("1- Atualizar CEP");
				System.out.println("2- Atualizar nome da rua");
				System.out.println("3- Atualizar o número do restaurante");
				System.out.println("4- voltar ao menu anterior");
				System.out.print("O que deseja fazer? ");
				
				// escolha para menu com endereço já cadastrado
				try {
					
					option = sc.nextInt();
					sc.nextLine();
					
					//verificar se a opção do usuário está fora do intervalo permitido
					if (!(option > 0 && option <= 4)) {
						System.out.println("Digite uma opção válida: ");
					}
					
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Digite apenas números: ");
					option = -1;
				}

				//acesso as opções do menu			
				switch (option) {
					case 1:
						this.atualizarCep(endereco);
						break;
					case 2:
						this.atualizarNome(endereco);
						break;
					case 3:
						this.atualizarNumero(endereco);
						break;
					case 4:
						System.out.println("Voltando ao menu anterior");
						return;
						
					default: 
						System.out.println("Opção inválida, tente novamente: ");
				}
				
			} while (option != 4);		
			

		} 
		
	}	
	
	/**
	 * Método cadastrarEndereco
	 * 
	 * Implementa o cadastro de um endereço para um restaurante
	 * 
	 * @param r objeto restaurante
	 */
	private void cadastrarEndereco(Restaurante r) {
		String cep;
		String nome;
		int numero;
	
		// validação do CEP
		System.out.println("Digite o CEP do restaurante (8 dígitos): ");
		while (true) {
			
			cep = sc.nextLine().trim();
			
			if (servicoendereco.cepValido(cep)) {
				break;
			} else {
				System.out.print("Utilize 8 digitos para o CEP: ");
			}
			
		}
		
		// validação do nome da rua do restaurante
		System.out.println("Digite o nome da rua do restaurante (até 100 dígitos): ");
		while (true) {
			
			nome = sc.nextLine().trim();
			
			if (servicoendereco.nomeValido(nome)) {
				break;
			} else {
				System.out.print("Nome inválido. Tente novamente: ");
			}
			
		}
		
		// validação do número do restaurante
		System.out.println("Digite o novo Número do restaurante (8 dígitos): ");
		while (true) {
			
			numero = sc.nextInt();
			sc.nextLine();
			
			if (servicoendereco.numeroValido(numero)) {
				break;
			} else {
				System.out.print("Utilize 8 digitos para o CEP: ");
			}
			
		}
		
		System.out.println("Confirmando informações: ");
		System.out.printf("CEP: %s\n", cep);
		System.out.printf("Nome da rua: %s\n", nome);
		System.out.printf("Número: %d\n", numero);
		System.out.print("Deseja confirmar as informações? (s para sim/n para cancelar): ");
		
		//validação da escolha do usuário
		while (true) {
			
			String opt = sc.next();
			
			if (opt.equals("s")) {
				//instanciação de um novo enderecorestaurante e vinculação dos atributos
				EnderecoRestaurante er = new EnderecoRestaurante();
				er.setCep(cep);
				er.setCnpjRestaurante(r.getCnpj());
				er.setNome(nome);
				er.setNumero(numero);
				
				
				//chamada do método para cadastro e verificação se houve êxito na ação
				if(servicoendereco.inserirEnderecoRestaurante(er)) {
					System.out.println("Endereço do Restaurante cadastrado com sucesso!");
					return;
					
				} else {
					System.out.println("Ocorreu um erro desconhecido ao cadastrar o Endereço.");
				}
				
				break;
				
			} else if (opt.equals("n")) {
				System.out.println("Nada foi alterado");
				return;
				
			} else {
				System.out.print("Opção inválida, tente novamente: ");
			}
			
		}
		
	}

	/**
	 * Método atualizarCep
	 * 
	 * Implementa a edição de apenas o Cep
	 * 
	 * @param er objeto endereçoRestaurante existence
	 */
	private void atualizarCep(EnderecoRestaurante er) {
		
		System.out.println("Digite o novo CEP do restaurante (8 dígitos): ");
		while (true) {
			
			String cep = sc.nextLine().trim();
			
			if (servicoendereco.cepValido(cep)) {
				er.setCep(cep);
				break;
			} else {
				System.out.print("Utilize 8 digitos para o CEP: ");
			}
			
		}
		
		if(servicoendereco.atualizarEnderecoRestaurante(er)) {
			System.out.println("Número do restaurante atualizado com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar as informações");
		}
		
	}
	
	/**
	 * Método atualizarNome
	 * 
	 * Implementa a edição de apenas o Nome
	 * 
	 * @param er objeto endereçoRestaurante existence
	 */
	private void atualizarNome(EnderecoRestaurante er) {
		
		System.out.println("Digite o nome da rua do restaurante (até 100 dígitos): ");
		while (true) {
			
			String nome = sc.nextLine().trim();
			
			if (servicoendereco.nomeValido(nome)) {
				er.setNome(nome);
				break;
			} else {
				System.out.print("Nome inválido. Tente novamente: ");
			}
			
		}
		
		if(servicoendereco.atualizarEnderecoRestaurante(er)) {
			System.out.println("Número do restaurante atualizado com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar as informações");
		}
	}
	
	/**
	 * Método atualizarNumero
	 * 
	 * Implementa a edição de apenas o Numero
	 * 
	 * @param er objeto endereçoRestaurante existence
	 */
	private void atualizarNumero(EnderecoRestaurante er) {
		
		System.out.println("Digite o novo Número do restaurante (8 dígitos): ");
		while (true) {
			
			int numero = sc.nextInt();
			sc.nextLine();
			
			if (servicoendereco.numeroValido(numero)) {
				er.setNumero(numero);
				break;
			} else {
				System.out.print("Utilize 8 digitos para o CEP: ");
			}
			
		}
		
		if(servicoendereco.atualizarEnderecoRestaurante(er)) {
			System.out.println("Número do restaurante atualizado com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar as informações");
		}
		
	}
	
}
