package com.example.paymentsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class PaymentApplicationUser extends EntityManager {

    @Column(name = "c_userName")
    private String userName;
    @Column(name = "c_password")
    private String password;


}
