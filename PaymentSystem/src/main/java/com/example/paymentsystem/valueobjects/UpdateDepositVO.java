package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Deposit;
import lombok.Data;

@Data
public class UpdateDepositVO {
    private Deposit deposit;
    private String trxNumber;
    private String customerNumber;
    private String depositNumber;


    public UpdateDepositVO(Deposit deposit, String trxNumber) {
        this.deposit = deposit;
        this.trxNumber = trxNumber;
    }

    public UpdateDepositVO() {
    }
}
