package com.example.paymentsystem.exception;

import com.example.paymentsystem.services.PerformTransactionServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(PerformTransactionServices.class);


    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        logger.error(ex.toString(), ex);
        model.addAttribute("errorMessage", ex.getMessage());
        return "error.jsp";
    }
}

