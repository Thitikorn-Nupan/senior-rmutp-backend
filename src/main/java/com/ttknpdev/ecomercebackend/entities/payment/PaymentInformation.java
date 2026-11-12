package com.ttknpdev.ecomercebackend.entities.payment;

import lombok.Data;

@Data
public class PaymentInformation {
    private Long amount;
    private String currency;
    private String sendToEmail;
}