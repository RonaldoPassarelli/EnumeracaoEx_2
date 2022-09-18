package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String bD = sc.nextLine();
		LocalDate birthDay = LocalDate.parse(bD, fmt1);
		//Instancia o Client client
		Client client = new Client(name, email, birthDay);
		System.out.println("Enter order data:");
		System.out.print("Status");
		String stat = sc.nextLine();
		OrderStatus status = OrderStatus.valueOf(stat);
		//Instancia Order order
		Order order = new Order(LocalDateTime.now(), status, client);
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i =0;i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name:");
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity :");
			int qtty = sc.nextInt();
			sc.nextLine();
			//instancia o Produto prod
			Product prod = new Product(prodName, price);
			//Instancia OrderItem ord
			OrderItem ord = new OrderItem(qtty, prod, prod.getPrice());
			order.addItem(ord);	
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		
		
				sc.close();
	}

}
