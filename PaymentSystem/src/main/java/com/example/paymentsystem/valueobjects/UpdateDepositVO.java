package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Deposit;
import lombok.Data;

@Data
public class UpdateDepositVO {
    private String customerNumber;
    private String depositNumber;

    private Integer state;

    public UpdateDepositVO() {
    }
}
