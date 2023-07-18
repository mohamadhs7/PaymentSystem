package com.example.paymentsystem.model.enums;

public enum TransactionStateEnum {

    Inserted(1),
    Success(2),
    Unsuccessful(3);


    public final Integer value;
    TransactionStateEnum(Integer type) { this.value = type; }
    public Integer getValue() {
        return value;
    }

    public static String getName(Integer state) {
        if (Inserted.getValue().equals(state))
            return "Inserted";
        else if (Success.getValue().equals(state))
            return "Success";
        else
            return "Unsuccessful";
    }
}

