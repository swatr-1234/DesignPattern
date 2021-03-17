package com.gslab.DesignPatterns.abstarctFactoryPattern.factory;

import com.gslab.DesignPatterns.abstarctFactoryPattern.service.BankService;
import com.gslab.DesignPatterns.constants.PaymentConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FactoryCreator {
    @Autowired
    private LoanFactory loanFactory;
    @Autowired
    private BankFactory bankFactory;

    private static final Map<String, AbstractFactory> handler = new HashMap<>();

    @PostConstruct
    private Map<String, AbstractFactory> getObject() {
        handler.put( PaymentConstants.LOAN, loanFactory );
        handler.put( PaymentConstants.BANK, bankFactory );
        return handler;
    }

    public static AbstractFactory getFactory( String choice ) {
        return Optional.ofNullable( handler.get( choice ) ).orElseThrow( () -> new IllegalArgumentException( "Invalid choice" ) );
    }
}
