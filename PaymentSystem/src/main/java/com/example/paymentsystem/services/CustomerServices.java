package com.example.paymentsystem.services;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.valueobjects.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    public void addCustomer(CustomerVO customerVO) {
        Customer customer = customerVO.cloneForDB();
        customerRepository.save(customer);
    }

}
