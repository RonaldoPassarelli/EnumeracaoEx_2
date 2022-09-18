package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>(); 
	
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public double total() {
		double sum = 0;
		for(OrderItem c: items)
			sum += c.getPrice() * c.getQuantity();
		return sum;
	}

	public String toString() {
		LocalDateTime inst = getMoment();
		String timeBefore = inst.toString();
		String meutempo = (timeBefore.substring(0, 10) + "T" + timeBefore.substring(11, 19));
		LocalDateTime ftBrazil = LocalDateTime.parse(meutempo);
		String finalTime = ftBrazil.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + finalTime + "\n");
		sb.append("Order Status: " + getStatus() + "\n");
		sb.append("Client: " + getClient() + "\n");
		sb.append("Order Itens: \n");
		for(OrderItem c:items) {
			sb.append(c.getProduct().getName() + ", $");
			sb.append(String.format("%.2f",c.getProduct().getPrice()) + ", ");
			sb.append("Quantity: " + c.getQuantity() + ", ");
			sb.append("Subtotal:  " + String.format("%.2f",c.subtotal()) + "\n");
		}
		sb.append("Total price: $" + total());
		return sb.toString();
	}


}
