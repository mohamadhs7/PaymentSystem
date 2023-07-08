package com.example.paymentsystem.controller;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.dao.PaymentTransactionRepository;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.DepositVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("home")
public class PaymentSystemMVCController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    DepositRepository depositRepo;

    @Autowired
    PaymentTransactionRepository paymentTransactionRepo;

    @GetMapping("customers")
    public ModelAndView showCustomers() {
        List<CustomerVO> customerVOList = customerRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerVOList);
        modelAndView.setViewName("customers.jsp");
        return modelAndView;
    }

    @GetMapping("deposits")
    public ModelAndView showDeposits() {
        List<DepositVO> depositVOList = depositRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deposits", depositVOList);
        modelAndView.setViewName("deposits.jsp");
        return modelAndView;
    }

    @GetMapping("transactions")
    public ModelAndView showTransactions() {
        List<TransactionVO> transactionVOList = paymentTransactionRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transactions", transactionVOList);
        modelAndView.setViewName("transactions.jsp");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView showHome() {
        List<CustomerVO> customerVOList = customerRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerVOList);
        modelAndView.setViewName("dashboard.jsp");
        return modelAndView;
    }

    @GetMapping("new-customer")
    public ModelAndView newCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-customer.jsp");
        return modelAndView;
    }
}
