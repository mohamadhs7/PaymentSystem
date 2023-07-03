package com.example.paymentsystem.controller;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.model.PaymentServiceLimitation;
import com.example.paymentsystem.model.PaymentTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanController {

    @Bean
    public Customer newCustomer() {
        return new Customer();
    }

    @Bean
    public Deposit newDeposit() {
        return new Deposit();
    }

    @Bean
    public PaymentTransaction newPaymentTransaction() {
        return new PaymentTransaction();
    }@Bean
    public PaymentServiceLimitation newPaymentServiceLimitation() {
        return new PaymentServiceLimitation();
    }
}
