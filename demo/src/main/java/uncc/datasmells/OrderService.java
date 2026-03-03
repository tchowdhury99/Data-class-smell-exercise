package edu.uncc.se;

public class OrderService {

    public double calculateTotal(Order order) {
        return order.getProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printOrderSummary(Order order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomer().getName());

        order.getProducts().forEach(product ->
                System.out.println("- " + product.getName() +
                        " $" + product.getPrice()));
    }
}