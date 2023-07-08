package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.model.enums.DepositStateEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class DepositVO implements Serializable {

    private String state;
    private Double balance;
    private String sourceIBAN;
    private String number;
    private String cardPan;

    public static DepositVO cloneFromDB(Deposit deposit) {
        DepositVO depositVO = new DepositVO();
        depositVO.setState(convertState(deposit.getState()));
        depositVO.setBalance(deposit.getBalance());
        depositVO.setSourceIBAN(deposit.getSourceIBAN());
        depositVO.setNumber(deposit.getNumber());
        depositVO.setCardPan(deposit.getCardPan());
        return depositVO;
    }

    public static String convertState(Integer state) {
        if (state.equals(DepositStateEnum.Open.getValue()))
            return "Open";

        if (state.equals(DepositStateEnum.Close.getValue()))
            return "Close";

        return "----";
    }

    }
