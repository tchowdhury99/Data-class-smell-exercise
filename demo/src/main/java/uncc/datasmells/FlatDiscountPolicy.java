package uncc.datasmells;

public class FlatDiscountPolicy implements DiscountPolicy {

    double amount; // no private/final

    public FlatDiscountPolicy(double amount) {
        Validation.nonNegative(amount, "discount");
        this.amount = amount;
    }

    public double discountOn(double baseAmount) {
        return amount;
    }

    public void changeAmount(double newAmount) {
        Validation.nonNegative(newAmount, "discount");
        this.amount = newAmount;
    }

    public boolean isZero() {
        return amount == 0.0;
    }
}