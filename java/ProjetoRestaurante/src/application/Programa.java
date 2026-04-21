package application;

import java.sql.Connection;
import database.DatabaseConnection;
import entities.Restaurante;
import database.AcessoDadosRestaurante;

import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("TEste");
		Connection conn = DatabaseConnection.getConnection();
		
		
		System.out.println("Connected successfully!");

	
	//Restaurante res = new Restaurante("123213", "Jambalaia", "112345", 0, "abc123");
	
	AcessoDadosRestaurante resdao = new AcessoDadosRestaurante(conn);
	
	Restaurante ativo = resdao.buscarPorCnpj("123213");
	
	ArrayList<Restaurante> restaurantes = resdao.listarRestaurantes();

	for (Restaurante x: restaurantes) {
		System.out.println("CNPJ: " + x.getCnpj() + " Nome: " + x.getNome() + " Telefone: " + x.getTelefone() + " Categoria: " +  String.valueOf(x.getIdCategoria()) + " senha: " + x.getSenha());

		}
		
	}


}
