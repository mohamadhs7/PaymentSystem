package com.example.paymentsystem;


import com.example.paymentsystem.dao.CustomerRepository;
import com.example.paymentsystem.dao.DepositRepository;
import com.example.paymentsystem.dao.PaymentTransactionRepository;
import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.Deposit;
import com.example.paymentsystem.model.enums.DepositStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@SpringBootApplication
public class PaymentSystemApplication {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DepositRepository depositRepository;

    @Autowired
    PaymentTransactionRepository transactionRepository;


    @Autowired
    WebApplicationContext webApplicationContext;

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(webApplicationContext);
        templateResolver.setOrder(9);
        templateResolver.setPrefix("/WEB-INF/view/");
        templateResolver.setSuffix("");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine springTemplateEngine= new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(thymeleafTemplateResolver());
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setViewNames(new String[] {"*.html"});
        viewResolver.setExcludedViewNames(new String[] {"*.jsp"});
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(10);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix("");
        viewResolver.setViewNames("*.jsp");
        return viewResolver;
    }
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

            Customer customer2 = new Customer();
            customer2.setNumber("20200");
            customer2.setPostalCode("1586666658");
            customer2.setState(1);
            customer2.setNationalCode("0023060773");
            customer2.setFirstName("Taghi");
            customer2.setLastName("Taghavi");
            customer2.setAddress("Rasht Hashemi St");
//            customer.setDeposits();
            customerRepository.save(customer2);

            Deposit deposit = new Deposit();
            deposit.setCustomer(customer);
            deposit.setState(DepositStateEnum.Open.state);
            deposit.setBalance(20000000D);
            deposit.setIBAN("IR310120020000000472264727");
            deposit.setNumber("1.1515.10220.1");
            deposit.setCardPan("5022291501892719");
            depositRepository.save(deposit);

            Deposit deposit2 = new Deposit();
            deposit2.setCustomer(customer2);
            deposit2.setState(DepositStateEnum.Open.state);
            deposit2.setBalance(40000D);
            deposit2.setIBAN("IR620120020000000534464727");
            deposit2.setNumber("2.1515.10220.1");
            deposit2.setCardPan("6219861922290910");
            depositRepository.save(deposit2);

//            PaymentTransaction paymentTransaction = new PaymentTransaction();
//            paymentTransaction.setId(2L);
//            paymentTransaction.setCustomerNumber("10220");
//            paymentTransaction.setSourceIBAN("IR620120020000000534464727");
//            paymentTransaction.setDestIBAN("IR310120020000000472264727");
//            paymentTransaction.setAmount(5D);
//            transactionRepository.save(paymentTransaction);
        };
    }

}
