package com.example.paymentsystem.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PaymentSystemConfigs {
    private static String volumeLimitation = "0";

    public void setVolumeLimitation(String newVolume) {
        volumeLimitation = newVolume;
    }

    public String getVolumeLimitation() {
        return volumeLimitation;
    }

}
