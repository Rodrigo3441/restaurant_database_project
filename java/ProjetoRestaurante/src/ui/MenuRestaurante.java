package ui;

import java.sql.Connection;
import java.util.Scanner;
import database.AcessoDadosRestaurante;
import entities.Restaurante;
import services.ServicoRestaurante;

/**
 * Classe: MenuRestaurante
 *
 * Descrição:
 * Classe responsável por oferecer a interface do sistema para o usuário
 *
 * Responsabilidades:
 * - oferecer menus interativos para o usuário
 *
 * @author Rodrigo
 * @since 23-04-2026
 */

public class MenuRestaurante {
	
	private Scanner sc = new Scanner(System.in);
	private ServicoRestaurante servicorestaurante;
	
	/**
	 * 
	 * @param servicerestaurante
	 */
	public MenuRestaurante(Connection conn) {
		this.servicorestaurante = new ServicoRestaurante(new AcessoDadosRestaurante(conn));
	}
	
	/**
	 * Método mostrarMenuPrincipal
	 * 
	 *
	 * 
	 */
	public void mostrarMenuPrincipal() {
			
			int option = 9;
			
			//validação da entrada de opção pelo usuário
			do {
				
				System.out.println("MENU RESTAURANTE");
				System.out.println("1- Iniciar Sessão");
				System.out.println("2- Fazer cadastro de restaurante");
				System.out.println("3- Voltar ao menu principal");
				
				try {
					
					option = sc.nextInt();
					
					//verificar se a opção do usuário está fora do intervalo permitido
					if (!(option >= 0 && option <= 3)) {
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
						this.fazerLogin();
						break;
						
					case 2:
						this.fazerCadastro();
						break;
						
					case 3:
						System.out.println("Voltando ao menu principal");
						return;
						
					default: 
						System.out.println("Opção inválida, tente novamente: ");
				}
	
				
			} while (option != 3);
			
		}
	
	
	/**
	 * Método fazerCadastro
	 * 
	 * 
	 */
	public void fazerCadastro() {
		
		String cnpj;
		String nome;
		String telefone;
		String senha;
		
		System.out.println("CADASTRO DE NOVO RESTAURANTE");
		
		//campo para validação de CNPJ
		System.out.print("Digite o CNPJ do seu restaurante (14 Dígitos): ");
		while (true) {
			
			cnpj = sc.next().trim();
			
			if(servicorestaurante.cnpjValido(cnpj)) {
				if(servicorestaurante.cnpjDisponivel(cnpj)) {
					break;
					
				} else {
					System.out.print("O CNPJ informado já está em uso, tente outro: ");
				}
				
			} else {
				System.out.print("Digite um CNPJ Válido: ");
			}
		}
		
		sc.nextLine();
		//campo para validação de Nome
		System.out.print("Insira o nome do restaurante (3-40 caracteres): ");
		while (true) {
			
			nome = sc.nextLine().trim();
			
			if (servicorestaurante.nomeValido(nome)) {
				break;
			} else {
				System.out.print("Utilize a quantidade de caracteres informada (3-40): ");
			}
			
		}
		
		//campo para validação de telefone
		System.out.print("Insira o telefone do restaurante (até 11 números): ");
		while (true) {
			
			telefone = sc.next().trim();
			
			if (servicorestaurante.telefoneValido(telefone)) {
				break;
			} else {
				System.out.print("Utilize apenas 11 dígitos para o telefone: ");
			}
		}
		
		//campo para validação de senha
		System.out.print("Insira a senha do restaurante: ");
		while (true) {
			
			senha = sc.next().trim();
			
			if (servicorestaurante.senhaValida(senha)) {
				break;
			} else {
				System.out.print("Senha inválida, tente novamente: ");
			}
		}
		
		System.out.println("Confirmando informações: ");
		System.out.printf("CNPJ: %s\n", cnpj);
		System.out.printf("Nome do restaurante: %s\n", nome);
		System.out.printf("Telefone: %s\n", telefone);
		System.out.printf("Senha do restaurante: %s\n\n", senha);
		System.out.print("Deseja confirmar as informações? (s para sim/n para cancelar): ");
		
		//validação da escolha do usuário
		while (true) {
			
			String opt = sc.next();
			
			if (opt.equals("s")) {
				//instanciação de um novo restaurante e vinculação dos atributos
				Restaurante r = new Restaurante();
				r.setCnpj(cnpj);
				r.setNome(nome);
				r.setTelefone(telefone);
				r.setSenha(senha);
				
				//chamada do método para cadastro e verificação se houve êxito na ação
				if(servicorestaurante.cadastrarRestaurante(r)) {
					System.out.println("Restaurante cadastrado com sucesso!");
					
				} else {
					System.out.println("Ocorreu um erro desconhecido ao cadastrar o restaurante.");
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
	 * Método fazerLogin
	 * 
	 * 
	 */
	public void fazerLogin() {
		System.out.print("Digite o seu CNPJ para poder inciar sessão: ");
		
		String cnpj = sc.next().trim();
		
		//armazena todas as informações do restaurante
		Restaurante r = servicorestaurante.retornarRestaurante(cnpj);
		
		//verifica se houve retorno para um restaurante
		if(r != null) {

			System.out.print("Digite a senha da sua conta: ");
			
			String senha = sc.next().trim();
			
			//verifica se o atributo senha de r confere com senha informada
			if (r.getSenha().equals(senha)) {
				System.out.println("Seja bem vindo, " + r.getNome() + "!");
				this.menuRestauranteLogado(r);
			} else {
				System.out.println("Usuário ou senha incorretos.");
			}
			
		} else {
			System.out.println("O CNPJ informado não está cadastrado. (será que você digitou errado?)");
		}
		
	}
	
	/**
	 * Método menuRestauranteLogado
	 * 
	 * @param r
	 */
	public void menuRestauranteLogado(Restaurante r) {
		int option = -1;
		do {
			System.out.println("MENU GERENCIADOR DO RESTAURANTE");
			System.out.println("O que deseja fazer?");
			System.out.println("1- Editar informações do restaurante");
			System.out.println("2- Gerenciar entregadores");
			System.out.println("3- Gerenciar produtos");
			System.out.println("4- Gerenciar pedidos");
			System.out.println("5- Fazer Logoff");
			
			try {
				
				option = sc.nextInt();
				
				//verificar se a opção do usuário está fora do intervalo permitido
				if (!(option >= 0 && option <= 5)) {
					System.out.println("Digite uma opção válida: ");
				}
				
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Digite apenas números: ");
				option = -1;
			}
			
			switch (option) {
				case 1:
					MenuPerfilRestaurante menuperfil = new MenuPerfilRestaurante(servicorestaurante);
					menuperfil.mostrarMenuPerfil(r);
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					System.out.println("Até uma próxima.");
					return;
			}
			
		} while (option != 5);
		
	}

}
