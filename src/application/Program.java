package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Enter Client data:");
		
		System.out.print("Name: ");
		String name = teclado.nextLine();
		
		System.out.print("Email: ");
		String email = teclado.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYY): ");
		String birthDate = teclado.nextLine();
		
		System.out.println();
		
		System.out.println("Enter order data: ");
		
		System.out.print("Status: ");
		String orderStatus = teclado.nextLine();
		
		System.out.print("How many items to this order? ");
		int n = teclado.nextInt();
		
		System.out.println();
		
				
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), new Client(name, email, sdf.parse(birthDate)));
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Enter #" + i + " Item Data: ");
			
			System.out.print("Product Name: ");
			teclado.nextLine();
			String productName = teclado.nextLine();
			
			System.out.print("Product Price: ");
			double productPrice = teclado.nextDouble();
			
			System.out.print("Quantity: ");
			int productQuantity = teclado.nextInt();
			
			OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(">>>> ORDER SUMMARY <<<<");
		System.out.println("Order Moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order Status: " + order.getStatus());
		System.out.println(order.getClient());
		System.out.println("**Order Items**");
		
		for(OrderItem o : order.getItens()) {
			System.out.println(o.toString());
		}
		
		
		
		
		teclado.close();
	}

}
