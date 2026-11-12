package com.ttknpdev.ecomercebackend.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.ttknpdev.ecomercebackend.dto.Purchase;
// import com.ttknpdev.ecomercebackend.entities.PaymentInfomation;
import com.ttknpdev.ecomercebackend.entities.payment.PaymentInformation;
import com.ttknpdev.ecomercebackend.log.Logback;
import com.ttknpdev.ecomercebackend.services.purchase.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/checkout")
public class CheckoutControl {
    private Logback logback;
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutControl(CheckoutService checkoutService) {
        logback = new Logback(CheckoutControl.class);
        this.checkoutService = checkoutService;
    }

    @PostMapping(value = "/purchase")
    private ResponseEntity placeOrders(@RequestBody Purchase purchase) {
        /*logback.log.warn("purchase {}\npurchase.getCustomer() {}\npurchase.getShippingAddress() {}\npurchase.purchase.getBillingAddress() {}\npurchase.purchase.getOrder().getOid() {}",purchase,
                purchase.getCustomer(),
                purchase.getShippingAddress(),
                purchase.getBillingAddress(),
                purchase.getOrder());*/
        return ResponseEntity.ok(checkoutService.placeOrders(purchase));
    }

    @PostMapping(value = "/create-payment-intent")
    private ResponseEntity createPaymentIntent(@RequestBody PaymentInformation paymentInfomation) throws StripeException {
        logback.log.warn("paymentInfomation {}",paymentInfomation);
        PaymentIntent paymentIntent = checkoutService.generatePaymentIntent(paymentInfomation);
        return ResponseEntity.ok(paymentIntent.toJson());
    }
}
