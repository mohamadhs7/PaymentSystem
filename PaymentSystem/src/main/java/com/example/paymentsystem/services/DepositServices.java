package com.example.paymentsystem.services;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.valueobjects.DepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServices {

    @Autowired
    DepositRepository depositRepo;

    @Autowired
    CustomerRepository customerRepo;

    public void addDeposit(DepositVO depositVO) {
        Customer customer = customerRepo.getCustomerByNumber(depositVO.getCustomerNumber());
        depositVO.setCustomer(customer);
        depositRepo.save(depositVO.cloneForDB());
    }



}
