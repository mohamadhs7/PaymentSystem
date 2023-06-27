package com.example.paymentsystem.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@javax.persistence.Entity
public class Deposit extends EntityManager {
    @ManyToOne
    @JoinColumn(name = "c_customer")
    private Customer customer;
    @Column(name = "c_state")
    private Integer state;
    @Column(name = "c_balance")
    private Double balance;
    @Column(name = "c_sourceIBAN")
    private String sourceIBAN;
    @Column(name = "c_destIBAN")
    private String destIBAN;
    @Column(name = "c_number")
    private String number;
    @Column(name = "c_cardPan")
    private String cardPan;


}
