package com.gslab.DesignPatterns.serviceLocatorPattern.service.impl;

import com.gslab.DesignPatterns.serviceLocatorPattern.entity.PaymentRequest;
import com.gslab.DesignPatterns.serviceLocatorPattern.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("Paytm")
public class PaytmServiceImplementation implements PaymentService {
    @Override
    public String pay( PaymentRequest req ) {
        return req.getAmount() + " amount paid successfully using " + req.getPaymentMethod();
    }
}
