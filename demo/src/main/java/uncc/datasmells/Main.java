package uncc.datasmells;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("C001", "Alice", "alice@example.com");

        Product p1 = new Product("P001", "Laptop", 1200.0);
        Product p2 = new Product("P002", "Mouse", 25.0);

        List<Product> products = Arrays.asList(p1, p2);

        Order order = new Order("O001", customer, products);

        double taxRate = 0.07;
        double discount = 50.0;

        TaxPolicy taxPolicy = new RateTaxPolicy(taxRate);
        DiscountPolicy discountPolicy = new FlatDiscountPolicy(discount);

        Invoice invoice = new Invoice("I001", order, taxPolicy, discountPolicy);

        OrderService service = new OrderService();

        service.printOrderSummary(order);

        double total = service.calculateTotal(order);
        System.out.println("Order Total: $" + total);

        service.printInvoiceSummary(invoice);
    }
}