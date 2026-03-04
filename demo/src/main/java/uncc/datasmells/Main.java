package uncc.datasmells;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("C001", "Alice", "alice@email.com");

        Product p1 = new Product("P001", "Laptop", 1200.0);
        Product p2 = new Product("P002", "Mouse", 25.0);

        Order order = new Order("O1001", customer, Arrays.asList(p1, p2));

        Invoice invoice = new Invoice("INV-01", order, 0.10, 50.0);

        OrderService service = new OrderService();

        service.printOrderSummary(order);

        double total = service.calculateTotal(order);
        System.out.println("Order Total: $" + total);

        service.printInvoiceSummary(invoice);
    }
}