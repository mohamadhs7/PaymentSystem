package com.example.paymentsystem;


import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.dao.PaymentTransactionRepository;
import com.example.paymentsystem.dao.UserRepository;
import com.example.paymentsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PaymentSystemApplication {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DepositRepository depositRepository;

    @Autowired
    PaymentTransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaymentSystemApplication.class, args);
    }


    @Bean
    CommandLineRunner runner() {

        return args -> {

            Customer customer = new Customer();
            customer.setNumber("10220");
            customer.setPostalCode("1483665958");
            customer.setState(1);
            customer.setNationalCode("0023060883");
            customer.setFirstName("Ali");
            customer.setLastName("Alavi");
            customer.setAddress("Tehran Hashemi St");
//            customer.setDeposits();
            customerRepository.save(customer);




        };
    }

}
