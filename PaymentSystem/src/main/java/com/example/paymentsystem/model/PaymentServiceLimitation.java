package com.example.paymentsystem.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import java.time.LocalDate;

@javax.persistence.Entity
@Data
public class PaymentServiceLimitation extends EntityManager {
    @Column(name = "c_customerNumber")
    private String customerNumber;
    @Column(name = "c_currentVolume")
    private Double currentVolume;
    @Column(name = "c_date")
    private LocalDate date;
    @Value("${volumeLimitation}")
    private String volumeLimitation;

}
