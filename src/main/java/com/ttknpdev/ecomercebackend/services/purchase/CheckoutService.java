package com.ttknpdev.ecomercebackend.services.purchase;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.ttknpdev.ecomercebackend.dto.Purchase;
import com.ttknpdev.ecomercebackend.entities.payment.PaymentInformation;
import com.ttknpdev.ecomercebackend.entities.purchase.Customer;
import com.ttknpdev.ecomercebackend.entities.purchase.Order;
import com.ttknpdev.ecomercebackend.entities.purchase.OrderItem;
import com.ttknpdev.ecomercebackend.log.Logback;
import com.ttknpdev.ecomercebackend.repositories.purchase.CustomerRepo;
import com.ttknpdev.ecomercebackend.services.items.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CheckoutService {

    @Getter
    @AllArgsConstructor
    class ResponsePlaceOrders {
        private String orderTrackingNumber;
    }

    private CustomerRepo customerRepo;
    private Logback logback;
    // for decrement unit in stock
    private ProductService productService;

    @Autowired
    public CheckoutService(CustomerRepo customerRepo,
                          @Value("${STRIPE.SECRET.KEY}") String stripeSecretKey,
                           ProductService productService) {
        this.customerRepo = customerRepo;
        this.logback = new Logback(CheckoutService.class);
        Stripe.apiKey = stripeSecretKey;
        this.productService = productService;
    }


    @Transactional
    // we have many repositories
    // we have to mark @Transactional for tell jpa
    // 1 transaction many repositories
    // if we do not 1 trans will be 1 repo
    public ResponsePlaceOrders placeOrders(Purchase purchase) {
        logback.log.warn("purchase {}",purchase);

        // retrieve order info from dto
        Order order = purchase.getOrder();

        // generate UUID code then set up to order object
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        logback.log.warn("order after called order.setOrderTrackingNumber(UUID) {}",order);

        // populate order either order item
        Set<OrderItem> orderItems = purchase.getOrderItems();

        orderItems.forEach(item -> {
           logback.log.warn("item.pid {}",item.getProductPid());
           order.addOrderItem(item);
            // ***** decrement unit in stock
            logback.log.warn("order {}",order);
            productService.updateUnitInStock(item.getQuantity(), item.getProductPid());
        });


        // populate order either address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate order either customer
        Customer customer = purchase.getCustomer();


        String email = customer.getEmail();
        Customer customerFromDatabase = customerRepo.findByEmail(email);

        // check if customer's email is existing
        if (customerFromDatabase != null) {
            logback.log.warn("customerFromDatabase {} already exists",customerFromDatabase);
            customer = customerFromDatabase;
        }

        // if purchase by prompt pay have to be false
        if (!purchase.getStatusPurchase()) {
            order.setStatusPurchase(false);
            // **
            order.setQrPurchaseUrl(purchase.getQrPurchaseUrl());
        } else {
            order.setStatusPurchase(true);
        }

        customer.addOrder(order);
        logback.log.warn("customer already to insert {} ",customer);

        // now customer already to query
        customerRepo.save(customer);

        return new ResponsePlaceOrders(orderTrackingNumber);
    }

    public PaymentIntent generatePaymentIntent(PaymentInformation paymentInformation) throws StripeException  {
        // for set types of payment intent
        List<String> paymentMethodTypes = new ArrayList<>();
        // for set params of payment intent ** object type can be many types
        Map<String, Object> params = new HashMap<>();

        paymentMethodTypes.add("card"); // other payment type as wechat_pay , ... but we use card
        // key is constant name
        params.put("payment_method_types", paymentMethodTypes);
        params.put("amount", paymentInformation.getAmount());
        params.put("currency", paymentInformation.getCurrency());
        // for send message to email after done
        // note card test api won auto sent to email
        // u can manual on https://dashboard.stripe.com/test/payments
        params.put("receipt_email", paymentInformation.getSendToEmail());
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        logback.log.warn("paymentIntent {}", paymentIntent);
        return paymentIntent;
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (it's 16 char ex, str36-sasa-fdfd56s-sds...)
        return UUID.randomUUID().toString();
    }
}
