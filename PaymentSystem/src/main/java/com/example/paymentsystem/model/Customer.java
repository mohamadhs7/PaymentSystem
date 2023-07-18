package com.example.paymentsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Customer extends EntityManager {
    @Column(name = "c_number")
    private String number;
    @Column(name = "c_postalCode")
    private String postalCode;
    @Column(name = "c_state")
    private Integer state;
    @Column(name = "c_nationalCode")
    private String nationalCode;
    @Column(name = "c_firstName")
    private String firstName;
    @Column(name = "c_lastName")
    private String lastName;
    @Column(name = "c_address")
    private String address;

}
