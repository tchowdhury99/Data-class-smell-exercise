package uncc.datasmells;

import java.util.ArrayList;
import java.util.List;

public class Order {

    String orderId;
    Customer customer;
    List<Product> products;

    public Order(String orderId, Customer customer, List<Product> products) {
        Validation.notBlank(orderId, "order id");
        Validation.notNull(customer, "customer");
        Validation.notNull(products, "products");
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>(products);
        validateNoNullProducts();
    }


    public double total() {
        double sum = 0.0;
        for (Product p : products) {
            sum += p.unitPrice();
        }
        return sum;
    }

    public int productCount() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product) {
        Validation.notNull(product, "product");
        products.add(product);
    }

    public boolean removeProductById(String productId) {
        Validation.notBlank(productId, "product id");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).matchesId(productId)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean containsFreeItem() {
        for (Product p : products) {
            if (p.isFree()) return true;
        }
        return false;
    }

    public void transferTo(Customer newCustomer) {
        Validation.notNull(newCustomer, "customer");
        this.customer = newCustomer;
    }

 
    public void printSummary() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.displayName());
        for (Product p : products) {
            System.out.println(p.receiptLine());
        }
    }

    void validateNoNullProducts() {
        for (Product p : products) {
            if (p == null) throw new ValidationException("product must not be null");
        }
    }
}