package uncc.datasmells;

public class RateTaxPolicy implements TaxPolicy {

    double rate;

    public RateTaxPolicy(double rate) {
        Validation.requireRange(rate, 0.0, 1.0, "tax rate");
        this.rate = rate;
    }

    public double taxAmount(double baseTotal) {
        return baseTotal * rate;
    }

    public double getRate() { return rate; }
    public void setRate(double rate) {
        Validation.requireRange(rate, 0.0, 1.0, "tax rate");
        this.rate = rate;
    }
}