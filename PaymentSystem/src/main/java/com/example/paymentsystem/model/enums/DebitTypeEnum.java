package com.example.paymentsystem.model.enums;

public enum DebitTypeEnum {
    IBAN(1),
    DepositNumber(2),
    CardPan(3);

    public final Integer type;
    DebitTypeEnum(Integer type) { this.type = type; }
    public Integer getType() {
        return type;
    }

}

