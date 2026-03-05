package uncc.datasmells;

public class RateTaxPolicy implements TaxPolicy {

    double rate; // no private/final

    public RateTaxPolicy(double rate) {
        Validation.inRange(rate, 0.0, 1.0, "tax rate");
        this.rate = rate;
    }

    public double taxOn(double baseAmount) {
        return baseAmount * rate;
    }

    public void changeRate(double newRate) {
        Validation.inRange(newRate, 0.0, 1.0, "tax rate");
        this.rate = newRate;
    }

    public boolean isZero() {
        return rate == 0.0;
    }
}