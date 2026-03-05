package uncc.datasmells;

public class FlatDiscountPolicy implements DiscountPolicy {

    double discount;

    public FlatDiscountPolicy(double discount) {
        Validation.requireNonNegative(discount, "discount");
        this.discount = discount;
    }

    public double discountAmount(double baseTotal) {
        return discount;
    }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) {
        Validation.requireNonNegative(discount, "discount");
        this.discount = discount;
    }
}