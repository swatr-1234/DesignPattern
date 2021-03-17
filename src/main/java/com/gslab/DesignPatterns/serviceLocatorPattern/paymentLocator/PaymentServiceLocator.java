package com.gslab.DesignPatterns.serviceLocatorPattern.paymentLocator;

import com.gslab.DesignPatterns.serviceLocatorPattern.registery.PaymentRegistery;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceLocator {
    @Bean
    public FactoryBean<?> getBean() {

        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface( PaymentRegistery.class );
        return bean;
    }
}
