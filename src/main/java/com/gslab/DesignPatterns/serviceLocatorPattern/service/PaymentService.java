package com.gslab.DesignPatterns.serviceLocatorPattern.service;

import com.gslab.DesignPatterns.serviceLocatorPattern.entity.PaymentRequest;

public interface PaymentService {

    public String pay( PaymentRequest req );
}
