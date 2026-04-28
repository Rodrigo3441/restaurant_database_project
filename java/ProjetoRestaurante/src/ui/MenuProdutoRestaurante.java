package ui;

import java.util.Scanner;

import entities.Produto;
import entities.Restaurante;
import services.ServicoProduto;

/**
 * Classe: MenuProdutoRestaurante
 *
 * Descrição:
 * Classe responsável por fornecer uma interface para que o restaurante possa gerenciar os seus produtos
 *
 * Responsabilidades:
 * - oferecer uma interface de comunicação dos dados
 * - se comunicar com a camada de serviço
 *
 * @author Rodrigo
 * @since 27-04-2026
 */

public class MenuProdutoRestaurante {
	
	private Scanner sc = new Scanner(System.in);
	private ServicoProduto servicoproduto = new ServicoProduto();
	
	/**
	 * Exibir o menu para o restaurante poder gerenciar os produtos de seu catálogo
	 * @param r objeto restaurante
	 */
	public void mostrarMenuProdutos(Restaurante r) {
		int option = 9;
		
		//validação da entrada de opção pelo usuário
		do {
			
			System.out.println("MENU PRODUTOS DO RESTAURANTE");
			System.out.println("1- Cadastrar um novo produto");
			System.out.println("2- Listar produtos");
			System.out.println("3- Atualizar um produto");
			System.out.println("4- Remover Produto");
			System.out.println("5- Voltar ao menu anterior");
			
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
					this.cadastrarProduto(r.getCnpj());
					break;
				case 2:
					this.listarProduto(r.getCnpj());
					break;
				case 3:
					this.atualizarProduto(r.getCnpj());
					break;
				case 4:
					this.removerProduto(r.getCnpj());
					break;
				case 5:
					return;
				
			}

		} while (option != 5);
		
	}
	
	/**
	 * Método cadastrarProduto
	 * Exibir a interface para o restaurante poder cadastrar um produto em seu catálogo
	 * Identifica se o produto já está cadastrado e será só associado, ou se será inserido do zero
	 * @param cnpj do restaurante em sessão
	 */
	private void cadastrarProduto(String cnpj) {
		String nomeProduto;
		
		//campo para validação do nome do produto
		while (true) {
			System.out.print("Insira o nome do produto que você deseja cadastrar (3-40 letras): ");
			nomeProduto = sc.nextLine().trim();

		    try {
		    	servicoproduto.validarNome(nomeProduto);
		        break;
		    } catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		    }
		}
		
		Produto p = servicoproduto.buscarProdutoPorNome(nomeProduto);
		
		//verificação se houve um produto com o mesmo nome retornado
		if (p != null) {
			System.out.print("Esse produto já está cadastrado no catálogo global. Deseja adicionar ele no catálogo do seu restaurante? (1-sim/2-não)");
			
			int option = 9;
			
			//validação da entrada de opção pelo usuário
			do {
				try {
					option = sc.nextInt();
					sc.nextLine();

				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Digite apenas números: ");
					option = -1;
				}
				
				//acesso as opções de decisão			
				switch (option) {
					case 1:
						this.cadastrarProdutoExistente(p, cnpj);
						return;
					case 2:
						System.out.println("A operação foi cancelada pelo usuário.");
						return;
					default:
					    System.out.println("Digite uma opção válida (1 ou 2)");
						
				}
	
			} while (true);
			
		}
			
		
		this.cadastrarProdutoNovo(cnpj, nomeProduto);

	}
		

	/**
	 * Método cadastrarProdutoNovo
	 * Se o nome de produto que o usuário digitou não for localizado na base de dados
	 * Ele será "redirecionado" para esse método, cadastrando globalmente em produtos, e depois
	 * associando ao restaurante
	 * @param cnpj
	 * @param nomeProduto
	 */
	private void cadastrarProdutoNovo(String cnpj, String nomeProduto) {
		int codigo;
		String descricaoProduto;
		
		//campo para validação da descrição do produto
		while (true) {
			System.out.print("Insira a descrição do produto: ");
			descricaoProduto = sc.nextLine().trim();

		    try {
		    	servicoproduto.validarDescricao(descricaoProduto);
		        break;
		    } catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		    }
		}
		
		//campo para validação do código do produto
		while (true) {
			System.out.print("Insira o código do produto no catálogo global (Um valor numérico): ");
			codigo = sc.nextInt();
			sc.nextLine();
			
		    try {
		    	servicoproduto.validarCodigo(codigo);
		        break;
		    } catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		    }
		}
		
		System.out.println("Confirmando informações: ");
		System.out.printf("Código global do produto: %s\n", codigo);
		System.out.printf("Nome do produto: %s\n", nomeProduto);
		System.out.printf("Descrição do produto: %s\n", descricaoProduto);
		System.out.print("Deseja confirmar as informações? (s para sim/n para cancelar): ");
		
		//validação da escolha do usuário
		while (true) {
			
			String opt = sc.next();
			
			if (opt.equals("s")) {
				//instanciação de um novo produto e vinculação dos atributos
				Produto p = new Produto();
				
				p.setCodigo(codigo);
				p.setNome(nomeProduto);
				p.setDescricao(descricaoProduto);
				
				//chamada do método para cadastro e verificação se houve êxito na ação
				if(servicoproduto.inserirProduto(p)) {
					System.out.println("Produto cadastrado com sucesso!");
					
				} else {
					System.out.println("Ocorreu um erro desconhecido ao tentar cadastrar.");
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
	
	private void cadastrarProdutoExistente(Produto p, String cnpj) {
		
	}
	
	private void listarProduto(String cnpj) {
		
	}
	
	private void atualizarProduto(String cnpj) {
		
	}
	
	private void removerProduto(String cnpj) {
		
	}
}
