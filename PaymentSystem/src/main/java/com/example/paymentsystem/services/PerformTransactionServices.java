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

        Customer destCustomer;
        Deposit sourceDeposit = null;
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

            sourceDeposit = depositRepository.getDepositByiBAN(transactionVO.getIdentifier());

            depositNullChecking(transactionVO, sourceDeposit);

            if (!(sourceDeposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

            transactionVO.setSourceIBAN(transactionVO.getIdentifier());
            transactionVO.setDepositNumber(sourceDeposit.getNumber());
            transactionVO.setCardPan(sourceDeposit.getCardPan());
        }

        if (transactionVO.getDebitType().equals(DebitTypeEnum.DepositNumber.getType())) {

            sourceDeposit = depositRepository.getDepositByNumber(transactionVO.getIdentifier());

            depositNullChecking(transactionVO, sourceDeposit);

            if (!(sourceDeposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

            transactionVO.setSourceIBAN(sourceDeposit.getIBAN());
            transactionVO.setDepositNumber(transactionVO.getIdentifier());
            transactionVO.setCardPan(sourceDeposit.getCardPan());

        }

        if (transactionVO.getDebitType().equals(DebitTypeEnum.CardPan.getType())) {

            sourceDeposit = depositRepository.getDepositByCardPan(transactionVO.getIdentifier());

            depositNullChecking(transactionVO, sourceDeposit);

            transactionVO.setSourceIBAN(sourceDeposit.getIBAN());
            transactionVO.setDepositNumber(sourceDeposit.getNumber());
            transactionVO.setCardPan(transactionVO.getIdentifier());

            if (!(sourceDeposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()) >= 0D))
                throw new Exception("Deposit Balance Is Not Enough");

        }

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

        transactionVO.setSourceDeposit(sourceDeposit);
        transactionVO.setDestDeposit(destDeposit);

    }

    public void doTransaction(TransactionVO transactionVO) throws Exception {
        PaymentTransaction transaction = transactionRepository.save(transactionVO.cloneForDB());
        Deposit sourceDeposit;
        Deposit destDeposit;
        try {
            transactionVO.setSource(true);
            sourceDeposit = updateDepositBalanceByIdentifier(transactionVO);
            transactionVO.setSource(false);
            destDeposit = updateDepositBalanceByIdentifier(transactionVO);
            transaction.setDebtorTrxNumber(generateTrxNumber());
            transaction.setCreditorTrxNumber(generateTrxNumber());
            transaction.setSourceIBAN(transactionVO.getSourceIBAN());
            transaction.setCardPan(transactionVO.getCardPan());
            transaction.setDepositNumber(transactionVO.getDepositNumber());
            customerServices.validateServiceLimitation(transactionVO);
            depositRepository.save(sourceDeposit);
            depositRepository.save(destDeposit);
            transactionVO.setDebtorTrxNumber(transaction.getDebtorTrxNumber());
            transactionVO.setCreditorTrxNumber(transaction.getCreditorTrxNumber());
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

    public Deposit updateDepositBalanceByIdentifier(TransactionVO transactionVO) {
        Deposit deposit;

        if (transactionVO.isSource()) {
            deposit = transactionVO.getSourceDeposit();
            deposit.setBalance(deposit.getBalance() - (transactionVO.getAmount() + transactionVO.getFeeAmount()));
        } else {
            deposit= transactionVO.getDestDeposit();
            deposit.setBalance(deposit.getBalance() + transactionVO.getAmount());
        }

        return deposit;
    }

    public static void depositNullChecking(TransactionVO transactionVO, Deposit deposit) throws Exception {
        if (deposit != null) {

            if (deposit.getState().equals(DepositStateEnum.Close.getValue()))
                throw new Exception("Deposit is Closed");

            Customer customer = deposit.getCustomer();

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

    }

    public static String generateTrxNumber() {
        return "SEP" + new Random().nextInt(1000000000) + "TRX";
    }
}
