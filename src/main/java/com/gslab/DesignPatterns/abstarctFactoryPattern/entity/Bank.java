package com.gslab.DesignPatterns.abstarctFactoryPattern.entity;

import jdk.jfr.DataAmount;

public class Bank {
    private String bankName;


    public Bank( String bankName ) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName( String bankName ) {
        this.bankName = bankName;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                '}';
    }
}
