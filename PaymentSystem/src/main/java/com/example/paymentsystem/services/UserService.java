//package com.example.paymentsystem.services;
//
//import com.example.paymentsystem.dao.UserRepository;
//import com.example.paymentsystem.model.PaymentApplicationUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public PaymentApplicationUser loadUser(String username, String password) throws UsernameNotFoundException {
//        PaymentApplicationUser user = userRepository.getByUserNameAndPassword(username, password);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//
//        return user;
//    }
//}
