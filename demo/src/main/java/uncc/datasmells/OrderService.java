package uncc.datasmells;

public class OrderService {

    public double calculateTotal(Order order) {
        Validation.requireNonNull(order, "order");
        return order.total();
    }

    public double calculateFinalAmount(Invoice invoice) {
        Validation.requireNonNull(invoice, "invoice");
        return invoice.finalAmount();
    }

    public void printOrderSummary(Order order) {
        Validation.requireNonNull(order, "order");
        order.printSummary();
    }

    public void printInvoiceSummary(Invoice invoice) {
        Validation.requireNonNull(invoice, "invoice");
        invoice.printSummary();
    }
}