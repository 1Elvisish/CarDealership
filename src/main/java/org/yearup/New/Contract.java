package org.yearup.New;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private String vehicleSold;

    public Contract(String date, String customerName, String customerEmail, String vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public Contract() {
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    public void printContract() {
        System.out.println("Contract Details:");
        System.out.println("Date: " + date);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Email: " + customerEmail);
        System.out.println("Vehicle Sold: " + vehicleSold);
        System.out.println("Total Price: " + getTotalPrice());
        System.out.println("Monthly Payment: " + getMonthlyPayment());
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}


