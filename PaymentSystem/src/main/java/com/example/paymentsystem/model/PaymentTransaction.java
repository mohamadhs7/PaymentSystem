package com.example.paymentsystem.model;

import lombok.Data;
import javax.persistence.Column;
import java.util.Date;

@javax.persistence.Entity
@Data
public class PaymentTransaction extends EntityManager {

    @Column(name = "c_amount")
    private Double amount;
    @Column(name = "c_feeAmount")
    private Double feeAmount;
    @Column(name = "c_debtorTrxNumber")
    private String debtorTrxNumber;
    @Column(name = "c_creditorTrxNumber")
    private String creditorTrxNumber;
    @Column(name = "c_sourceIBAN")
    private String sourceIBAN;
    @Column(name = "c_destIBAN")
    private String destIBAN;
    @Column(name = "c_depositNumber")
    private String depositNumber;
    @Column(name = "c_cardPan")
    private String cardPan;
    @Column(name = "c_transactionType")
    private Integer transactionType;
    @Column(name = "c_creditorName")
    private String creditorName;
    @Column(name = "c_debtorName")
    private String debtorName;
    @Column(name = "c_terminalType")
    private Integer terminalType;
    @Column(name = "c_state")
    private Integer state;
    @Column(name = "c_branchId")
    private Long branchId;
    @Column(name = "c_date")
    private Date date;
    @Column(name = "c_customerNumber")
    private String customerNumber;
    @Column(name = "c_description")
    private String description;
    @Column(name = "c_instructionId")
    private String instructionId;
    @Column(name = "c_debitType")
    private Integer debitType;

}
