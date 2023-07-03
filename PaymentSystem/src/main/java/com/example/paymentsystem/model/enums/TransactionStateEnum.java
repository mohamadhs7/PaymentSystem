package com.example.paymentsystem.model.enums;

public enum TransactionStateEnum {

    Inserted(1),
    InProgress(2),
    Success(3),
    UnSuccess(4);


    public final Integer value;
    TransactionStateEnum(Integer type) { this.value = type; }
    public Integer getValue() {
        return value;
    }
}

