package com.example.paymentsystem.services;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.PaymentServiceLimitationRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.PaymentServiceLimitation;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PaymentServiceLimitationRepository paymentServiceLimitationRepo;

    public void addCustomer(CustomerVO customerVO) {
        Customer customer = customerVO.cloneForDB();
        customerRepository.save(customer);
    }

    public void validateServiceLimitation(TransactionVO transactionVO) throws Exception {
        PaymentServiceLimitation paymentServiceLimitation = paymentServiceLimitationRepo.getPaymentServiceLimitationByCustomerNumberAndDate(transactionVO.getCustomerNumber(), LocalDate.now());

        if (paymentServiceLimitation == null)
            paymentServiceLimitation = paymentServiceLimitationRepo.saveByTransactionVO(transactionVO);

        double newCurrentVolume = paymentServiceLimitation.getCurrentVolume() + transactionVO.getAmount();
        double volumeLimitation = Double.parseDouble(paymentServiceLimitation.getVolumeLimitation());

        if (newCurrentVolume > volumeLimitation)
            throw new Exception("Service Limitation Is Not Valid");

        paymentServiceLimitation.setCurrentVolume(newCurrentVolume);
        paymentServiceLimitationRepo.save(paymentServiceLimitation);

    }


}
