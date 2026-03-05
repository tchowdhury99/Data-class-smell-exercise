package uncc.datasmells;

public class Invoice {

    String invoiceId;
    Order order;

    // Keep these for compatibility with Main :contentReference[oaicite:10]{index=10}
    double taxRate;
    double discount;

    // OOP strategies (polymorphism)
    TaxPolicy taxPolicy;
    DiscountPolicy discountPolicy;

    public Invoice(String invoiceId, Order order, double taxRate, double discount) {
        Validation.requireNonBlank(invoiceId, "invoice id");
        Validation.requireNonNull(order, "order");
        Validation.requireRange(taxRate, 0.0, 1.0, "tax rate");
        Validation.requireNonNegative(discount, "discount");

        this.invoiceId = invoiceId;
        this.order = order;
        this.taxRate = taxRate;
        this.discount = discount;

        // Default strategies preserve current behavior exactly
        this.taxPolicy = new RateTaxPolicy(taxRate);
        this.discountPolicy = new FlatDiscountPolicy(discount);
    }

    // Behavior: invoice knows how to compute itself
    public double finalAmount() {
        double base = order.total();
        double tax = taxPolicy.taxAmount(base);
        double disc = discountPolicy.discountAmount(base);
        return base + tax - disc;
    }

    // Behavior: keep EXACT same output formatting as original printInvoiceSummary :contentReference[oaicite:11]{index=11}
    public void printSummary() {
        System.out.println("\nInvoice ID: " + invoiceId);
        double finalAmount = finalAmount();
        System.out.println("Final Amount (with tax & discount): $" + finalAmount);
    }

    // Accessors kept
    public String getInvoiceId() { return invoiceId; }
    public void setInvoiceId(String invoiceId) {
        Validation.requireNonBlank(invoiceId, "invoice id");
        this.invoiceId = invoiceId;
    }

    public Order getOrder() { return order; }
    public void setOrder(Order order) {
        Validation.requireNonNull(order, "order");
        this.order = order;
    }

    public double getTaxRate() { return taxRate; }
    public void setTaxRate(double taxRate) {
        Validation.requireRange(taxRate, 0.0, 1.0, "tax rate");
        this.taxRate = taxRate;
        if (taxPolicy instanceof RateTaxPolicy) {
            ((RateTaxPolicy) taxPolicy).setRate(taxRate);
        }
    }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) {
        Validation.requireNonNegative(discount, "discount");
        this.discount = discount;
        if (discountPolicy instanceof FlatDiscountPolicy) {
            ((FlatDiscountPolicy) discountPolicy).setDiscount(discount);
        }
    }

    // Optional polymorphism configuration (not used by Main; output unchanged)
    public TaxPolicy getTaxPolicy() { return taxPolicy; }
    public void setTaxPolicy(TaxPolicy taxPolicy) {
        Validation.requireNonNull(taxPolicy, "tax policy");
        this.taxPolicy = taxPolicy;
    }

    public DiscountPolicy getDiscountPolicy() { return discountPolicy; }
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        Validation.requireNonNull(discountPolicy, "discount policy");
        this.discountPolicy = discountPolicy;
    }
}