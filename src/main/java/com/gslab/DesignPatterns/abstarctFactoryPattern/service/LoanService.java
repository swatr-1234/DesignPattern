package com.gslab.DesignPatterns.abstarctFactoryPattern.service;

import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Bank;
import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Loan;

public interface LoanService {

    public String loanType( Loan loan );
}
