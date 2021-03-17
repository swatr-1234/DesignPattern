package com.gslab.DesignPatterns.abstarctFactoryPattern.factory;

import com.gslab.DesignPatterns.abstarctFactoryPattern.service.BankService;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.LoanService;


public interface AbstractFactory {
    public BankService getBankDetails( String bankName);
    public LoanService getLoanDetails( String loanType);
}
