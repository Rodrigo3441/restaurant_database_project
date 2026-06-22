package ui;

import java.sql.Connection;
import java.util.Scanner;

import ui.customer.CustomerMenu;
import ui.restaurant.RestaurantMenu;

/**
 * Class: MainMenu
 *
 * Description:
 * Responsible for displaying the main user interaction menu of the system.
 *
 * Responsibilities:
 * - Show access options for Customers and Restaurants
 * - Perform basic navigation between menus
 *
 * @author Rodrigo
 * @since 23-04-2026
 */

public class MainMenu {
	
	private Scanner sc;
	private Connection conn;
	
	/**
	 * Constructor
	 *
	 * @param conn Database connection used by menus
	 * @param sc   Scanner for reading user input
	 */
	public MainMenu(Connection conn, Scanner sc) {
		this.conn = conn;
		this.sc = sc;
	}
	
	/**
	 * Display method
	 *
	 * Responsible for showing the main menu on the screen for system users,
	 * whether Customers or Restaurants.
	 */
	public void mostrar() {
		
		int option = 9;
		
		// validate user's menu option input
		while (true) {
			
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("================================================");
			System.out.println("Fred Food - Delivery");
			System.out.println("Seja bem vindo ao nosso sistema!\n");
			
			System.out.println("1- Acessar menu para clientes");
			System.out.println("2- Acessar menu para restaurantes");
			System.out.println("3- Sair do sistema");
			System.out.println("================================================\n");
			System.out.print("Informe a ação desejada: ");
			
			try {
				
				option = sc.nextInt();
				
				// check if the user's option is outside the allowed range
				if (!(option >= 0 && option <= 3)) {
					System.out.println("Digite uma opção válida: ");
				}
				
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Digite apenas números: ");
				option = -1;
			}
			
			// handle menu options
			switch (option) {
				case 1:
					CustomerMenu menucliente = new CustomerMenu(conn, sc);
					menucliente.mostrarMenuPrincipal();
					break;
	
				case 2:
					RestaurantMenu menurestaurante = new RestaurantMenu(conn, sc);
					menurestaurante.mostrarMenuPrincipal();
					break;
					
				case 3:
					System.out.println("Obrigado por utilizar o Fred Food Delivery");
					return;
			}

		}
				
	}
	
}
