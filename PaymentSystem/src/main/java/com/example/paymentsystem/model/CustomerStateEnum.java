package com.example.paymentsystem.model;

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
}
