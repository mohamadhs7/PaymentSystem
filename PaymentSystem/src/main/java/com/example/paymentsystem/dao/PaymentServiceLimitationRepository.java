package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.PaymentServiceLimitation;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PaymentServiceLimitationRepository extends JpaRepository<PaymentServiceLimitation, Long> {

    PaymentServiceLimitation getPaymentServiceLimitationByCustomerNumberAndDate(String customerNumber, LocalDate localDate);

    default PaymentServiceLimitation saveByTransactionVO(TransactionVO transactionVO) {
        PaymentServiceLimitation paymentServiceLimitation = new PaymentServiceLimitation();
        paymentServiceLimitation.setCustomerNumber(transactionVO.getCustomerNumber());
        paymentServiceLimitation.setDate(LocalDate.now());
        paymentServiceLimitation.setCurrentVolume(0D);
        return save(paymentServiceLimitation);
    }

}
