package com.example.paymentsystem.dao;

import com.example.paymentsystem.model.PaymentApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PaymentApplicationUser, Long> {
    PaymentApplicationUser getByUserNameAndPassword(String userName, String password);
}
