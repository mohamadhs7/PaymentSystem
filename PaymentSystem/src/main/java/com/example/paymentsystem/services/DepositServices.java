package com.example.paymentsystem.services;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.valueobjects.DepositVO;
import com.example.paymentsystem.valueobjects.UpdateDepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DepositServices {

    @Autowired
    DepositRepository depositRepo;

    @Autowired
    CustomerRepository customerRepo;

    public void addDeposit(DepositVO depositVO) throws Exception {
        Customer customer = customerRepo.getCustomerByNumber(depositVO.getCustomerNumber());
        if (customer == null)
            throw new Exception("Customer Number Is Not Valid");
        depositVO.setCustomer(customer);
        depositRepo.save(depositVO.cloneForDB());
    }

    public void addCardPan(UpdateDepositVO updateDepositVO) throws Exception {
        Deposit deposit = depositRepo.getDepositByNumber(updateDepositVO.getDepositNumber());

        if (deposit == null)
            throw new Exception("Deposit Number Is Not Valid");

        if (!updateDepositVO.getCustomerNumber().equals(deposit.getCustomer().getNumber()))
            throw new Exception("Customer Number Is Not Valid");

        deposit.setCardPan(generateCardPan());
        depositRepo.save(deposit);
    }

    public static String generateCardPan() {
        int randomNumber = 10000000 + new Random ().nextInt(90000000);
        return "62198619" + randomNumber;
    }

}
