package com.gslab.DesignPatterns.serviceLocatorPattern.controller;

import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Bank;
import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Loan;
import com.gslab.DesignPatterns.abstarctFactoryPattern.factory.FactoryCreator;
import com.gslab.DesignPatterns.factoryMethodPattern.factoryImpl.PaymentServiceFactory;
import com.gslab.DesignPatterns.serviceLocatorPattern.entity.PaymentRequest;
import com.gslab.DesignPatterns.serviceLocatorPattern.registery.PaymentRegistery;
import com.gslab.DesignPatterns.serviceLocatorPattern.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {

    @Autowired
    PaymentRegistery registery;

    @PostMapping("/pay")
    public String paymentProcessing(@RequestBody PaymentRequest req ){

        return registery.getServiceBean( req.getPaymentMethod() ).pay( req );

    }

    @GetMapping("/pay")
    public String paymentProcessingByFactoryMethod(@RequestBody PaymentRequest req ) throws Exception {

        PaymentService src=PaymentServiceFactory.createInstance( req.getPaymentMethod() );
        return  src.pay( req );

    }
    @GetMapping("/pay/bank/{objectType}")
    public String abstractFactoryMethodBankImplementation(@PathVariable("objectType") String objectType,@RequestBody Bank bank ) throws Exception {

        return FactoryCreator.getFactory( objectType ).getBankDetails( bank.getBankName()).bankDetails( bank );

    }
    @GetMapping("/pay/loan/{objectType}")
    public String abstractFactoryMethodLoanImplementation(@PathVariable("objectType") String objectType,@RequestBody Loan loan ) throws Exception {

        return FactoryCreator.getFactory( objectType ).getLoanDetails( loan.getLoanType() ).loanType( loan );

    }
}
