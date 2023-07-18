package com.example.paymentsystem.model.enums;

public enum DepositStateEnum {

    Open(1),
    Close(2);

    public final Integer state;

    DepositStateEnum(Integer state) {
        this.state = state;
    }

    public Integer getValue() {
        return state;
    }

    public static String getName(Integer state) {
        if (Open.getValue().equals(state))
            return "Open";
        else
            return "Close";
    }
}
