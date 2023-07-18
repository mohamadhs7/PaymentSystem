package com.example.paymentsystem.services;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.dao.PaymentTransactionRepository;
import com.example.paymentsystem.model.*;
import com.example.paymentsystem.model.enums.*;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.DepositVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import com.example.paymentsystem.valueobjects.UpdateDepositVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.Random;

@Service
public class PerformTransactionServices {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DepositRepository depositRepository;

    @Autowired
    PaymentTransactionRepository transactionRepository;

    @Autowired
    CustomerServices customerServices;

    private static final Logger logger = LoggerFactory.getLogger(PerformTransactionServices.class);

    public void debtorTransaction(TransactionVO transactionVO) throws Exception {
        validateTransaction(transactionVO);
        doTransaction(transactionVO);
    }

    public void validateTransaction(TransactionVO transactionVO) throws Exception {

        Customer customer;
        Customer destCustomer;
        Deposit deposit = null;
        Deposit destDeposit;
        String destIban = transactionVO.getDestIBAN();

        if (!(transactionVO.getAmount() > 0D))
            throw new Exception("Amount is Not Valid");

        if (StringUtils.isEmpty(transactionVO.getInstructionId()))
            throw new Exception("Instruction Id Is Not Valid");

        transactionVO.setDate(new Date());
        transactionVO.setFeeAmount(600D);

        if (transactionVO.getDebitType().equals(DebitTypeEnum.IBAN.getType())) {

            if (StringUtils.isEmpty(transactionVO.getIdentifier()) || !transactionVO.getIdentifier().contains("IR"))
                throw new Exception("Source IBAN Is Not Valid");

            deposit = depositRepository.getDepositByiBAN(transactionVO.getIdentifier());

            if (!(deposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

            transactionVO.setSourceIBAN(transactionVO.getIdentifier());
            transactionVO.setDepositNumber(deposit.getNumber());

        }

        if (transactionVO.getDebitType().equals(DebitTypeEnum.DepositNumber.getType())) {

            deposit = depositRepository.getDepositByNumber(transactionVO.getIdentifier());

            if (!(deposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

        }

        if (transactionVO.getDebitType().equals(DebitTypeEnum.CardPan.getType())) {

            deposit = depositRepository.getDepositByCardPan(transactionVO.getIdentifier());

            if (!(deposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

        }

        if (deposit != null) {

            if (deposit.getState().equals(DepositStateEnum.Close.getValue()))
                throw new Exception("Deposit is Closed");

            customer = deposit.getCustomer();

            if (!customer.getNumber().equals(transactionVO.getCustomerNumber()))
                throw new Exception("Customer Number is Not Correct");

            if (customer.getState().equals(CustomerStateEnum.Block.getType()))
                throw new Exception("Customer is Block");

            transactionVO.setDebtorName(customer.getFirstName() + "" + customer.getLastName());
            transactionVO.setDebtorState(CustomerStateEnum.getState(customer.getState()).name());
            transactionVO.setDebtorNationalCode(customer.getNationalCode());
            transactionVO.setDebtorPostalCode(customer.getPostalCode());

        } else
            throw new Exception("There is No Deposit On " + transactionVO.getIdentifier());

        if (StringUtils.isEmpty(destIban) || !destIban.contains("IR"))
            throw new Exception("Destination IBAN Is Not Valid");

        destDeposit = depositRepository.getDepositByiBAN(transactionVO.getDestIBAN());

        if (destDeposit != null) {

            if (destDeposit.getState().equals(DepositStateEnum.Close.getValue()))
                throw new Exception("Destination Deposit is Closed");

            destCustomer = destDeposit.getCustomer();

            transactionVO.setCreditorName(destCustomer.getFirstName() + "" + destCustomer.getLastName());
            transactionVO.setCreditorState(CustomerStateEnum.getState(destCustomer.getState()).name());
            transactionVO.setCreditorNationalCode(destCustomer.getNationalCode());
            transactionVO.setCreditorPostalCode(destCustomer.getPostalCode());

        } else
            throw new Exception("There is No Deposit On " + transactionVO.getDestIBAN());

    }

    public void doTransaction(TransactionVO transactionVO) throws Exception {
        PaymentTransaction transaction = transactionRepository.save(transactionVO.cloneForDB());
        try {
            transactionVO.setMathOperation(MathOperationEnum.MINUS.getValue());
            transactionVO.setSource(true);
            UpdateDepositVO debtorDeposit = updateDepositBalanceByIdentifier(transactionVO);
            transactionVO.setMathOperation(MathOperationEnum.SUM.getValue());
            transactionVO.setSource(false);
            UpdateDepositVO creditorDeposit = updateDepositBalanceByIdentifier(transactionVO);
            transaction.setDebtorTrxNumber(debtorDeposit.getTrxNumber());
            transaction.setCreditorTrxNumber(creditorDeposit.getTrxNumber());
            transaction.setSourceIBAN(transactionVO.getSourceIBAN());
            transaction.setCardPan(transactionVO.getCardPan());
            transaction.setDepositNumber(transactionVO.getDepositNumber());
            customerServices.validateServiceLimitation(transactionVO);
            depositRepository.save(debtorDeposit.getDeposit());
            depositRepository.save(creditorDeposit.getDeposit());
            transactionVO.setDebtorTrxNumber(debtorDeposit.getTrxNumber());
            transactionVO.setCreditorTrxNumber(creditorDeposit.getTrxNumber());
            transactionVO.setDescription("Transaction Is Done Successfully");
            transaction.setState(TransactionStateEnum.Success.value);
            transactionRepository.save(transaction);
        } catch (Throwable e) {
            transaction.setState(TransactionStateEnum.Unsuccessful.value);
            transaction.setDebtorTrxNumber(null);
            transaction.setCreditorTrxNumber(null);
            transactionRepository.save(transaction);
            throw e;
        }
    }

    public UpdateDepositVO updateDepositBalanceByIdentifier(TransactionVO transactionVO) {
        Deposit deposit = null;

        if (DebitTypeEnum.IBAN.getType().equals(transactionVO.getDebitType())) {
            deposit = depositRepository.getDepositByiBAN(transactionVO.getIdentifier());

            if (transactionVO.isSource()) {
                transactionVO.setSourceIBAN(transactionVO.getIdentifier());
                transactionVO.setDepositNumber(deposit.getNumber());
                transactionVO.setCardPan(deposit.getCardPan());
            }

        } else if (DebitTypeEnum.DepositNumber.getType().equals(transactionVO.getDebitType())) {
            deposit = depositRepository.getDepositByNumber(transactionVO.getIdentifier());

            if (transactionVO.isSource()) {
                transactionVO.setSourceIBAN(deposit.getIBAN());
                transactionVO.setDepositNumber(transactionVO.getIdentifier());
                transactionVO.setCardPan(deposit.getCardPan());
            }

        } else if (DebitTypeEnum.CardPan.getType().equals(transactionVO.getDebitType())) {
            deposit = depositRepository.getDepositByCardPan(transactionVO.getIdentifier());

            if (transactionVO.isSource()) {
                transactionVO.setSourceIBAN(deposit.getIBAN());
                transactionVO.setDepositNumber(deposit.getNumber());
                transactionVO.setCardPan(transactionVO.getIdentifier());
            }
        }


        if (transactionVO.getMathOperation().equals(MathOperationEnum.SUM.getValue()))
            deposit.setBalance(deposit.getBalance() + transactionVO.getAmount());
        else if (transactionVO.getMathOperation().equals(MathOperationEnum.MINUS.getValue()))
            deposit.setBalance(deposit.getBalance() - transactionVO.getAmount());

        return new UpdateDepositVO(deposit, generateTrxNumber());
    }

    public static String generateTrxNumber() {
        return "SEP" + new Random().nextInt(1000000000) + "TRX";
    }
}
