package com.gslab.DesignPatterns.abstarctFactoryPattern.factory;

import com.gslab.DesignPatterns.abstarctFactoryPattern.service.BankService;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.LoanService;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl.EducationLoanServiceImplementation;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl.HomeLoanServiceImplementation;
import com.gslab.DesignPatterns.constants.PaymentConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("Loan")
public class LoanFactory implements AbstractFactory {


    @Autowired
    private HomeLoanServiceImplementation homeLoanServiceImplementation;
    @Autowired
    private EducationLoanServiceImplementation educationLoanServiceImplementation;
    private static final Map<String, LoanService> handler = new HashMap<>();

    @PostConstruct
    private Map<String, LoanService> getObject() {
        handler.put( PaymentConstants.HOME_LOAN, homeLoanServiceImplementation );
        handler.put( PaymentConstants.EDUCATIONAL_LOAN, educationLoanServiceImplementation );
        return handler;
    }

    @Override
    public LoanService getLoanDetails( String loanType ) {

        return Optional.ofNullable( handler.get( loanType ) ).orElseThrow( () -> new IllegalArgumentException( "Invalid Loan Type" ) );
    }

    @Override
    public BankService getBankDetails( String bankName ) {
        return null;
    }
}
