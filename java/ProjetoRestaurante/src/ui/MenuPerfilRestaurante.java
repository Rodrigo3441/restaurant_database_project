package ui;

import java.util.Scanner;

import entities.Restaurante;
import services.ServicoRestaurante;

/**
 * Classe: MenuPerfilRestaurante
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

public class MenuPerfilRestaurante {
	
	private Scanner sc = new Scanner(System.in);
	private ServicoRestaurante servicorestaurante;
	
	/**
	 * 
	 * @param servicorestaurante
	 */
	public MenuPerfilRestaurante(ServicoRestaurante servicorestaurante) {
		this.servicorestaurante = servicorestaurante;
	}
	

	/**
	 * Método mostrarMenuPerfil
	 * 
	 * @param r
	 */
	public void mostrarMenuPerfil(Restaurante r) {
		int option = 9;
		
		//validação da entrada de opção pelo usuário
		do {
			
			System.out.println("MENU EDITAR PERFIL DO RESTAURANTE");
			System.out.println("1- Atualizar nome");
			System.out.println("2- Atualizar telefone");
			System.out.println("3- Atualizar senha");
			System.out.println("4- Atualizar endereço");
			System.out.println("5- Atualizar categoria");
			System.out.println("6- Sair da edição de perfil");
			
			try {
				
				option = sc.nextInt();
				sc.nextLine();
				
				//verificar se a opção do usuário está fora do intervalo permitido
				if (!(option >= 0 && option <= 6)) {
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
					this.atualizarNome(r);
					break;
				case 2:
					this.atualizarTelefone(r);
					break;
				case 3:
					this.atualizarSenha(r);
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					return;
				
			}

		} while (option != 3);
		
	}
	
	/**
	 * Método atualizarNome
	 * 
	 * @param r
	 */
	public void atualizarNome(Restaurante r) {
		String nome;
		//campo para validação de Nome
		System.out.print("Insira o novo nome do restaurante (3-40 caracteres): ");
		while (true) {
			
			nome = sc.nextLine().trim();
			sc.nextLine();
			
			if (servicorestaurante.nomeValido(nome)) {
				break;
			} else {
				System.out.print("Utilize a quantidade de caracteres informada (3-40): ");
			}
			
		}
		
		r.setNome(nome);
		
		//atualiza e verifica se houve exito
		if(servicorestaurante.atualizarRestaurante(r)) {
			System.out.println("Nome atualizado com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar o nome.");
		}
	}
	
	/**
	 * Método atualizarTelefone
	 * 
	 * @param r
	 */
	public void atualizarTelefone(Restaurante r) {
		String telefone;
		//campo para validação de telefone
		System.out.print("Insira o novo telefone do restaurante (até 11 números): ");
		while (true) {
			
			telefone = sc.next().trim();
			
			if (servicorestaurante.telefoneValido(telefone)) {
				break;
			} else {
				System.out.print("Utilize apenas 11 dígitos para o telefone: ");
			}
		}
			
		r.setTelefone(telefone);
		
		//atualiza e verifica se houve exito
		if(servicorestaurante.atualizarRestaurante(r)) {
			System.out.println("Telefone atualizado com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar o telefone.");
		}
	}
	
	/**
	 * Método atualizarSenha
	 * 
	 * 
	 * @param r
	 */
	public void atualizarSenha(Restaurante r) {
		String senha;
		//campo para validação de telefone
		System.out.print("Insira a nova senha do restaurante: ");
		while (true) {
			
			senha = sc.next().trim();
			
			if (servicorestaurante.senhaValida(senha)) {
				break;
			} else {
				System.out.print("Senha inválida, tente novamente: ");
			}
		}
			
		r.setSenha(senha);
		
		//atualiza e verifica se houve exito
		if(servicorestaurante.atualizarRestaurante(r)) {
			System.out.println("senha atualizada com sucesso!");
		} else {
			System.out.println("Ocorreu um erro ao atualizar a senha.");
		}
	}
	
}
