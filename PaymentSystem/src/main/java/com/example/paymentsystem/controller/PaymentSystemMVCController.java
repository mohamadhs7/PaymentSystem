package com.example.paymentsystem.controller;

import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.dao.PaymentTransactionRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.services.CustomerServices;
import com.example.paymentsystem.services.DepositServices;
import com.example.paymentsystem.valueobjects.CustomerVO;
import com.example.paymentsystem.valueobjects.DepositVO;
import com.example.paymentsystem.valueobjects.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class PaymentSystemMVCController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    DepositRepository depositRepo;

    @Autowired
    PaymentTransactionRepository paymentTransactionRepo;

    @Autowired
    CustomerServices customerServices;

    @Autowired
    DepositServices depositServices;


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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard.jsp");
        return modelAndView;
    }

    @GetMapping("new-customer")
    public ModelAndView newCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer",new CustomerVO());
        modelAndView.setViewName("new-customer.jsp");
        return modelAndView;
    }

    @GetMapping("new-deposit")
    public ModelAndView newDeposit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-deposit.jsp");
        return modelAndView;
    }

    @RequestMapping("/addCustomer")
    public ModelAndView addCard(@ModelAttribute("customer") CustomerVO customer){
        customerServices.addCustomer(customer);
        List<CustomerVO> customerVOList = customerRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerVOList);
        modelAndView.setViewName("customers.jsp");
        return modelAndView;
    }

    @RequestMapping("/addDeposit")
    public ModelAndView addDeposit(@ModelAttribute("deposit") DepositVO deposit){
        depositServices.addDeposit(deposit);
        List<DepositVO> depositVOList = depositRepo.findAllInVO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deposits", depositVOList);
        modelAndView.setViewName("deposits.jsp");
        return modelAndView;
    }

}
