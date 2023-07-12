package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.valueobjects.DepositVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    Deposit getDepositByiBAN(String sourceIBAN);
    Deposit getDepositByNumber(String depositNumber);
    Deposit getDepositByCardPan(String cardPan);

    default List<DepositVO> findAllInVO() {
        List<DepositVO> depositVOList = new ArrayList<>();
        List<Deposit> deposits = findAll();
        for (Deposit deposit : deposits)
            depositVOList.add(DepositVO.cloneFromDB(deposit));
        return depositVOList;
    }

}
