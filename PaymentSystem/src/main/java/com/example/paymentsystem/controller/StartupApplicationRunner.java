package com.example.paymentsystem.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class StartupApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        String mainPageUrl = "http://localhost:8080/";
        try {
            Runtime.getRuntime().exec("xdg-open " + mainPageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

