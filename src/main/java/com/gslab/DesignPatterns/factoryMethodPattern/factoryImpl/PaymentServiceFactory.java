package com.gslab.DesignPatterns.factoryMethodPattern.factoryImpl;

import com.gslab.DesignPatterns.constants.PaymentConstants;
import com.gslab.DesignPatterns.serviceLocatorPattern.service.PaymentService;
import com.gslab.DesignPatterns.serviceLocatorPattern.service.impl.PaytmServiceImplementation;
import com.gslab.DesignPatterns.serviceLocatorPattern.service.impl.PhonePayServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentServiceFactory {
    @Autowired
    private PaytmServiceImplementation paytmServiceImplementation;
    @Autowired
    private PhonePayServiceImplementation phonePayServiceImplementation;

    private static final Map<String, PaymentService> handler = new HashMap<>();

    @PostConstruct
    private Map<String, PaymentService> getObject() {
        handler.put( PaymentConstants.PAYTM, paytmServiceImplementation );
        handler.put( PaymentConstants.PHONE_PAY, phonePayServiceImplementation );
        return handler;
    }

    public static PaymentService createInstance( String paymentMethod ) throws Exception {

        return Optional.ofNullable( handler.get( paymentMethod ) ).orElseThrow( () -> new IllegalArgumentException( "Invalid Payment Method" ) );
    }

}
