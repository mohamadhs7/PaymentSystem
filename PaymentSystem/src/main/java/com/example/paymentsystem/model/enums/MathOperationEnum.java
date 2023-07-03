package com.example.paymentsystem.model.enums;

public enum MathOperationEnum {

    SUM(1),
    MINUS(2);


    public final Integer value;
    MathOperationEnum(Integer type) { this.value = type; }
    public Integer getValue() {
        return value;
    }
}
