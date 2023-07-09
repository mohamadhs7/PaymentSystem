package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.model.enums.DepositStateEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Random;

@Data
public class DepositVO implements Serializable {

    private String state;
    private Double balance;
    private String sourceIBAN;
    private String number;
    private String cardPan;
    private String customerNumber;
    private Customer customer;

    public static DepositVO cloneFromDB(Deposit deposit) {
        DepositVO depositVO = new DepositVO();
        depositVO.setState(convertState(deposit.getState()));
        depositVO.setBalance(deposit.getBalance());
        depositVO.setSourceIBAN(deposit.getSourceIBAN());
        depositVO.setNumber(deposit.getNumber());
        depositVO.setCardPan(deposit.getCardPan());
        return depositVO;
    }

    public Deposit cloneForDB() {
        Deposit deposit = new Deposit();
        deposit.setCustomer(this.customer);
        deposit.setState(Integer.valueOf(this.state));
        deposit.setBalance(this.balance);
        deposit.setSourceIBAN(this.sourceIBAN);
        deposit.setNumber(String.valueOf(new Random().nextInt(100000)));
        return deposit;
    }

    public static String convertState(Integer state) {
        if (state.equals(DepositStateEnum.Open.getValue()))
            return "Open";

        if (state.equals(DepositStateEnum.Close.getValue()))
            return "Close";

        return "----";
    }

    }
