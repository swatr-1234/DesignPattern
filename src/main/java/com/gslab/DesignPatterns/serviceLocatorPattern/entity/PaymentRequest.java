package com.gslab.DesignPatterns.serviceLocatorPattern.entity;

public class PaymentRequest {
    private long amount;
    private String paymentMethod;

    public PaymentRequest( long amount, String paymentMethod ) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount( long amount ) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod( String paymentMethod ) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
