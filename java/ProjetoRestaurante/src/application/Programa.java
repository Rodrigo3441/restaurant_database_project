package application;

import java.sql.Connection;
import database.DatabaseConnection;

import entities.Produto;
import entities.Restaurante;
import database.AcessoDadosProduto;
import database.AcessoDadosRestaurante;

import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//definição da conexão
		System.out.println("TEste");
		Connection conn = DatabaseConnection.getConnection();
		
		
		System.out.println("Connected successfully!");

		AcessoDadosRestaurante restconn = new AcessoDadosRestaurante(conn);
		

		//insere um novo restaurante
		Restaurante alvo = new Restaurante("1234", "Batata Top", "119857383", 1, "senha123");
				
		//executa e verifica se foi inserido corretamente
		if (restconn.inserirRestaurante(alvo)) {
			System.out.println("Restaurante cadastrado com sucesso!");
		};

		//imprime o nome atual
		System.out.println(restconn.retornarRestaurante("1234").getNome());

		//atualiza o nome com um novo
		alvo.setNome("Batata Não Top");

		//envia o objeto com as novas informações para a camada de manipulação
		if (restconn.atualizarRestaurante(alvo)) {
			System.out.println("Restaurante alterado com sucesso!");
		};
			
		//imprime o novo nome
		System.out.println(restconn.retornarRestaurante("1234").getNome());
	}
}
