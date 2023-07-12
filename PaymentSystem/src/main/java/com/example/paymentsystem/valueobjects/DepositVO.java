package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Deposit;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Random;

@Data
public class DepositVO implements Serializable {

    private Integer state;
    private Double balance;
    private String iBAN;
    private String number;
    private String cardPan;
    private String customerNumber;
    private Customer customer;

    public static DepositVO cloneFromDB(Deposit deposit) {
        DepositVO depositVO = new DepositVO();
        depositVO.setState(deposit.getState());
        depositVO.setBalance(deposit.getBalance());
        depositVO.setIBAN(deposit.getIBAN());
        depositVO.setNumber(deposit.getNumber());
        depositVO.setCardPan(deposit.getCardPan());
        if (deposit.getCustomer() != null)
            depositVO.setCustomerNumber(deposit.getCustomer().getNumber());
        return depositVO;
    }

    public Deposit cloneForDB() {
        Deposit deposit = new Deposit();
        deposit.setCustomer(this.customer);
        deposit.setState(this.state);
        deposit.setBalance(this.balance);
        deposit.setIBAN(generateIBAN());
        deposit.setNumber(generateDepositNumber());
        return deposit;
    }

    public static String generateIBAN() {
        Random random = new Random();
        BigInteger randomNumber = new BigInteger(19 * 4, random);
        String formattedNumber = String.format("%019d", randomNumber);
        return "IR" + formattedNumber;
    }

    public static String generateDepositNumber() {
        return new Random().nextInt(10) + "." + new Random().nextInt(100000) + "." + "254";
    }
}
