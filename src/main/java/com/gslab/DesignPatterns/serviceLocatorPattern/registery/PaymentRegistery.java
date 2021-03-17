package com.gslab.DesignPatterns.serviceLocatorPattern.registery;

import com.gslab.DesignPatterns.serviceLocatorPattern.service.PaymentService;

public interface PaymentRegistery {

    public PaymentService getServiceBean(String serviceName);
}
