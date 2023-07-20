package com.example.paymentsystem.valueobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCustomerVO implements Serializable {

    private String customerNumber;
    private Integer state;
}
