package uncc.datasmells;

public class OrderService {

    public double calculateTotal(Order order) {
        Validation.notNull(order, "order");
        return order.total();
    }

    public double calculateFinalAmount(Invoice invoice) {
        Validation.notNull(invoice, "invoice");
        return invoice.finalAmount();
    }

    public void printOrderSummary(Order order) {
        Validation.notNull(order, "order");
        order.printSummary();
    }

    public void printInvoiceSummary(Invoice invoice) {
        Validation.notNull(invoice, "invoice");
        invoice.printSummary();
    }
}