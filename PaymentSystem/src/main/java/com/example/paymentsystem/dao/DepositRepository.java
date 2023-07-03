package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    Deposit getDepositBySourceIBAN(String sourceIBAN);
    Deposit getDepositByNumber(String depositNumber);
    Deposit getDepositByCardPan(String cardPan);

}
