package com.gslab.DesignPatterns.abstarctFactoryPattern.service.impl;

import com.gslab.DesignPatterns.abstarctFactoryPattern.entity.Bank;
import com.gslab.DesignPatterns.abstarctFactoryPattern.service.BankService;
import org.springframework.stereotype.Service;

@Service("SBI")
public class SbiBankServiceImplementation implements BankService {
    @Override
    public String bankDetails( Bank bank ) {
        return "BankName for the payment " + bank.getBankName();
    }
}
