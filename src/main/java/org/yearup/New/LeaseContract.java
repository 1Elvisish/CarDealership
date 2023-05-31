package org.yearup.New;

public class LeaseContract extends Contract {
    private double expectingEndingValue;
    private double leaseFee;

    public LeaseContract(String contractDate, String customerName, String customerEmail, String vehicleSold, double expectingEndingValue, double leaseFee) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.expectingEndingValue = expectingEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectingEndingValue() {
        return expectingEndingValue;
    }

    public void setExpectingEndingValue(double expectingEndingValue) {
        this.expectingEndingValue = expectingEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double originalPrice = getExpectingEndingValue() / 0.5; // Calculate the original price
        return originalPrice + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        double originalPrice = getExpectingEndingValue() / 0.5; // Calculate the original price
        double interestRate = 0.04; // 4.0% interest rate
        int leaseDuration = 36; // 36 months

        double monthlyInterestRate = interestRate / 12;
        double numerator = originalPrice * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, leaseDuration);
        double denominator = Math.pow(1 + monthlyInterestRate, leaseDuration) - 1;
        return numerator / denominator;
    }
}
