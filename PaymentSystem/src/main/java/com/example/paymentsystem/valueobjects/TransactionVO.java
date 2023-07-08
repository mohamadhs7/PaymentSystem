package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.PaymentTransaction;
import com.example.paymentsystem.model.enums.TransactionStateEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TransactionVO implements Serializable {

    private Double amount;
    private Double feeAmount;
    private String identifier;
    private String debtorTrxNumber;
    private String creditorTrxNumber;
    private String sourceIBAN;
    private String destIBAN;
    private String depositNumber;
    private String cardPan;
    private Integer transactionType;
    private String creditorName;
    private String debtorName;
    private Integer terminalType;
    private Integer state;
    private Long branchId;
    private Date date;
    private String customerNumber;
    private String instructionId;
    private String description;
    private Integer debitType;
    private Integer mathOperation;

    public static TransactionVO cloneFromDB(PaymentTransaction transaction) {
        TransactionVO transactionVO = new TransactionVO();
        transactionVO.setAmount(transaction.getAmount());
        transactionVO.setFeeAmount(transaction.getFeeAmount());
        transactionVO.setDebtorTrxNumber(transaction.getDebtorTrxNumber());
        transactionVO.setCreditorTrxNumber(transaction.getCreditorTrxNumber());
        transactionVO.setSourceIBAN(transaction.getSourceIBAN());
        transactionVO.setDestIBAN(transaction.getDestIBAN());
        transactionVO.setDepositNumber(transaction.getDepositNumber());
        transactionVO.setCardPan(transaction.getCardPan());
        transactionVO.setTransactionType(transaction.getTransactionType());
        transactionVO.setCreditorName(transaction.getCreditorName());
        transactionVO.setDebtorName(transaction.getDebtorName());
        transactionVO.setTerminalType(transaction.getTerminalType());
        transactionVO.setState(transaction.getState());
        transactionVO.setBranchId(transaction.getBranchId());
        transactionVO.setDate(transaction.getDate());
        transactionVO.setCustomerNumber(transaction.getCustomerNumber());
        transactionVO.setInstructionId(transaction.getInstructionId());
        transactionVO.setDescription(transaction.getDescription());
        transactionVO.setDebitType(transaction.getDebitType());
        return transactionVO;
    }


    public PaymentTransaction cloneForDB() {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setAmount(this.amount);
        paymentTransaction.setFeeAmount(this.feeAmount);
        paymentTransaction.setSourceIBAN(this.sourceIBAN);
        paymentTransaction.setDestIBAN(this.destIBAN);
        paymentTransaction.setDepositNumber(this.depositNumber);
        paymentTransaction.setCardPan(this.cardPan);
        paymentTransaction.setTransactionType(this.transactionType);
        paymentTransaction.setCreditorName(this.creditorName);
        paymentTransaction.setDebtorName(this.debtorName);
        paymentTransaction.setTerminalType(this.terminalType);
        paymentTransaction.setState(this.state);
        paymentTransaction.setBranchId(this.branchId);
        paymentTransaction.setDate(this.date);
        paymentTransaction.setCustomerNumber(this.customerNumber);
        paymentTransaction.setDescription(this.description);
        paymentTransaction.setInstructionId(this.instructionId);
        paymentTransaction.setDebitType(this.debitType);
        paymentTransaction.setState(TransactionStateEnum.Inserted.value);
        return paymentTransaction;
    }

}
