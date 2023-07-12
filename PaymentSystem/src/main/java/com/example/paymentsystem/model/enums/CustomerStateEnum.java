package com.example.paymentsystem.model.enums;

public enum CustomerStateEnum {
    Normal(1),
    Block(2);

    public final Integer type;
    CustomerStateEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static CustomerStateEnum getState(Integer state) {
        if (state == 1)
            return Normal;
        else
            return Block;
    }
}
