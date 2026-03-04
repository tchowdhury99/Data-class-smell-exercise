package uncc.datasmells;

public class Invoice {

    private String invoiceId;
    private Order order;
    private double taxRate;
    private double discount;

    public Invoice(String invoiceId, Order order, double taxRate, double discount) {
        this.invoiceId = invoiceId;
        this.order = order;
        this.taxRate = taxRate;
        this.discount = discount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}