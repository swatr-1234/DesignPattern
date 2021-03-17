package com.gslab.DesignPatterns.abstarctFactoryPattern.entity;

public class Loan {
    private String loanType;

    public Loan() {
    }

    public Loan( String loanType ) {
        this.loanType = loanType;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType( String loanType ) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanType='" + loanType + '\'' +
                '}';
    }
}
