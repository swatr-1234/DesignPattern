package com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl;

import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Loan;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.LoanService;
import org.springframework.stereotype.Service;

@Service("EDUCATIONAL_LOAN")
public class EducationLoanServiceImplementation implements LoanService {
    @Override
    public String loanType( Loan loan ) {
        return "Loan type is " + loan.getLoanType();
    }
}
