package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.valueobjects.CustomerVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByNumber(String number);

    default List<CustomerVO> findAllInVO() {
        List<CustomerVO> customerVOList = new ArrayList<>();
        List<Customer> customers = findAll();
        for (Customer customer : customers)
            customerVOList.add(CustomerVO.cloneFromDB(customer));
        return customerVOList;
    }
}
