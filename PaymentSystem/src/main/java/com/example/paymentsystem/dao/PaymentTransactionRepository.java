package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.PaymentTransaction;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.DepositVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {

    default List<TransactionVO> findAllInVO() {
        List<TransactionVO> transactionVOList = new ArrayList<>();
        List<PaymentTransaction> transactions = findAll();
        for (PaymentTransaction transaction : transactions)
            transactionVOList.add(TransactionVO.cloneFromDB(transaction));
        return transactionVOList;
    }

}
