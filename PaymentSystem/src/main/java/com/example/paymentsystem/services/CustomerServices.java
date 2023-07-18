package com.example.paymentsystem.services;

import com.example.paymentsystem.controller.PaymentSystemConfigs;
import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.PaymentServiceLimitationRepository;
import com.example.paymentsystem.exception.GlobalExceptionHandler;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.PaymentServiceLimitation;
import com.example.paymentsystem.model.enums.TransactionStateEnum;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PaymentServiceLimitationRepository paymentServiceLimitationRepo;

    @Autowired
    PaymentSystemConfigs paymentSystemConfigs;


    public void addCustomer(CustomerVO customerVO) {
        Customer customer = customerVO.cloneForDB();
        customerRepository.save(customer);
    }

    public void validateServiceLimitation(TransactionVO transactionVO) throws Exception {
        PaymentServiceLimitation paymentServiceLimitation = paymentServiceLimitationRepo.getPaymentServiceLimitationByCustomerNumberAndDate(transactionVO.getCustomerNumber(), LocalDate.now());

        if (paymentServiceLimitation == null)
            paymentServiceLimitation = paymentServiceLimitationRepo.saveByTransactionVO(transactionVO);

        double newCurrentVolume = paymentServiceLimitation.getCurrentVolume() + transactionVO.getAmount();
        double volumeLimitation = Double.parseDouble(paymentSystemConfigs.getVolumeLimitation());

        if (newCurrentVolume > volumeLimitation)
            throw new Exception("Service Limitation Is Not Valid");

        paymentServiceLimitation.setCurrentVolume(newCurrentVolume);
        paymentServiceLimitationRepo.save(paymentServiceLimitation);

    }

}
