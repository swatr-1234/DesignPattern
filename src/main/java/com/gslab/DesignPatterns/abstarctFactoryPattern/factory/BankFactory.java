package com.gslab.DesignPatterns.abstarctFactoryPattern.factory;

import com.gslab.DesignPatterns.abstarctFactoryPattern.service.LoanService;
import com.gslab.DesignPatterns.constants.PaymentConstants;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.BankService;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl.HdfcBankServiceImplementation;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl.SbiBankServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("Bank")
public class BankFactory implements AbstractFactory {
    @Autowired
    private HdfcBankServiceImplementation hdfcBankServiceImplementation;
    @Autowired
    private SbiBankServiceImplementation sbiBankServiceImplementation;

    private static final Map<String, BankService> handler = new HashMap<>();

    @PostConstruct
    private Map<String, BankService> getObject() {
        handler.put( PaymentConstants.HDFC, hdfcBankServiceImplementation );
        handler.put( PaymentConstants.SBI, sbiBankServiceImplementation );
        return handler;
    }

    @Override
    public BankService getBankDetails( String bankName ) {
        return Optional.ofNullable( handler.get( bankName ) ).orElseThrow( () -> new IllegalArgumentException( "Invalid Bank Name" ) );

    }

    @Override
    public LoanService getLoanDetails( String loanType ) {
        return null;
    }
}
