package com.ttknpdev.ecomercebackend.controllers;
import com.ttknpdev.ecomercebackend.entities.orders_history_admin.OrdersHistory;
import com.ttknpdev.ecomercebackend.entities.purchase.Order;
import com.ttknpdev.ecomercebackend.services.orders_history_admin.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class OrderControl {
    private final OrderService orderService;

    @Autowired
    public OrderControl(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/search/{email}")
    public ResponseEntity<List<Order>> readsByEmail(@PathVariable String email) {
        return ResponseEntity.accepted().body(this.orderService.getOrdersByCustomerEmail(email)); // if token expired will throw 401
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<OrdersHistory>> reads() {

        List<OrdersHistory> ordersHistories = this.orderService.getOrders();
        System.out.println("*******************************************");
        for (OrdersHistory ordersHistory : ordersHistories) {
            System.out.println(ordersHistory);
        }
        System.out.println("*******************************************");
        return ResponseEntity.accepted().body(ordersHistories); // if token expired or not admin
    }

    @GetMapping(value = "/only-perfumes")
    public ResponseEntity<List<OrdersHistory>> readsOnlyPerfumes() {
        List<OrdersHistory> ordersHistories = this.orderService.getOrdersOnlyPerfumes();
//        System.out.println("*******************************************");
//        for (OrdersHistory ordersHistory : ordersHistories) {
//            System.out.println(ordersHistory);
//        }
        System.out.println("*******************************************");
        return ResponseEntity.accepted().body(ordersHistories); // if token expired or not admin
    }

    @PutMapping(value = "/update-status-purchase")
    public ResponseEntity<Boolean> updateStatusPurchase(@RequestBody HashMap<String,String> json) {
        String orderTrackingNumber = json.get("orderTrackingNumber");
        // System.out.println("track is "+orderTrackingNumber);
        return ResponseEntity.accepted().body(orderService.updateStatusPurchaseByOrderTrackingNumber(orderTrackingNumber));
    }

}
