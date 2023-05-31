package org.yearup.New;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String contractDate, String customerName, String customerEmail, String vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean isFinanced) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getProcessingFee();
        double total = vehiclePrice + vehiclePrice * getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
        return total;
    }

    @Override
    public double getMonthlyPayment() {
        double vehiclePrice = getProcessingFee();
        double interestRate;
        int loanDuration;
        if (vehiclePrice >= 10000) {
            interestRate = 0.0425; // 4.25% interest rate
            loanDuration = 48; // 48 months
        } else {
            interestRate = 0.0525; // 5.25% interest rate
            loanDuration = 24; // 24 months
        }

        if (isFinanced()) {
            double monthlyInterestRate = interestRate / 12;
            double numerator = vehiclePrice * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanDuration);
            double denominator = Math.pow(1 + monthlyInterestRate, loanDuration) - 1;
            return numerator / denominator;
        } else {
            return 0; // No loan, so monthly payment is 0
        }
    }
}

