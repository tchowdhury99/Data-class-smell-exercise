package uncc.datasmells;

public class OrderService {

    public double calculateTotal(Order order) {
        return order.getProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public double calculateFinalAmount(Invoice invoice) {
        double base = calculateTotal(invoice.getOrder());
        double tax = base * invoice.getTaxRate();
        return base + tax - invoice.getDiscount();
    }

    public void printOrderSummary(Order order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomer().getName());

        order.getProducts().forEach(product ->
                System.out.println("- " + product.getName() +
                        " $" + product.getPrice()));
    }

    public void printInvoiceSummary(Invoice invoice) {
        System.out.println("\nInvoice ID: " + invoice.getInvoiceId());
        double finalAmount = calculateFinalAmount(invoice);
        System.out.println("Final Amount (with tax & discount): $" + finalAmount);
    }
}