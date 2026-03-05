package uncc.datasmells;

public class Invoice {

    String invoiceId;
    Order order;

    TaxPolicy taxPolicy;
    DiscountPolicy discountPolicy;

    public Invoice(String invoiceId, Order order, TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        Validation.notBlank(invoiceId, "invoice id");
        Validation.notNull(order, "order");
        Validation.notNull(taxPolicy, "tax policy");
        Validation.notNull(discountPolicy, "discount policy");
        this.invoiceId = invoiceId;
        this.order = order;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }


    public double finalAmount() {
        double base = order.total();
        double tax = taxPolicy.taxOn(base);
        double discount = discountPolicy.discountOn(base);
        return base + tax - discount;
    }

    public double taxAmount() {
        return taxPolicy.taxOn(order.total());
    }

    public double discountAmount() {
        return discountPolicy.discountOn(order.total());
    }

    public boolean hasAnyAdjustments() {
        return taxAmount() != 0.0 || discountAmount() != 0.0;
    }

    public void changeTaxPolicy(TaxPolicy newPolicy) {
        Validation.notNull(newPolicy, "tax policy");
        this.taxPolicy = newPolicy;
    }

    public void changeDiscountPolicy(DiscountPolicy newPolicy) {
        Validation.notNull(newPolicy, "discount policy");
        this.discountPolicy = newPolicy;
    }

 
    public void printSummary() {
        System.out.println("\nInvoice ID: " + invoiceId);
        System.out.println("Final Amount (with tax & discount): $" + finalAmount());
    }
}