package uncc.datasmells;

import java.util.List;

public class Order {

    String orderId;
    Customer customer;
    List<Product> products;

    public Order(String orderId, Customer customer, List<Product> products) {
        Validation.requireNonBlank(orderId, "order id");
        Validation.requireNonNull(customer, "customer");
        Validation.requireNonNull(products, "products");

        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    // Behavior: move “business meaning” into the object
    public double total() {
        double sum = 0.0;
        for (Product p : products) {
            if (p == null) {
                throw new ValidationException("product must not be null");
            }
            sum += p.getPrice();
        }
        return sum;
    }

    // Behavior: keep EXACT same output formatting as original printOrderSummary :contentReference[oaicite:8]{index=8}
    public void printSummary() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        for (Product p : products) {
            System.out.println(p.receiptLine());
        }
    }

    // Accessors kept
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) {
        Validation.requireNonBlank(orderId, "order id");
        this.orderId = orderId;
    }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) {
        Validation.requireNonNull(customer, "customer");
        this.customer = customer;
    }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) {
        Validation.requireNonNull(products, "products");
        this.products = products;
    }
}