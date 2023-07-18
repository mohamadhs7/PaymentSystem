package com.example.paymentsystem.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PaymentSystemConfigs {

    @Value("${volumeLimitation}")
    private String volumeLimitation;

}
