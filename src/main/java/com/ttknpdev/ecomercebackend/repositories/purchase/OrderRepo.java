package com.ttknpdev.ecomercebackend.repositories.purchase;

import com.ttknpdev.ecomercebackend.entities.purchase.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email);
    // *** work before purchase
    @Transactional
    @Modifying
    @Query(value = "update orders set status_purchase = true where order_tracking_number = :order_tracking_number", nativeQuery = true)
    void updateStatusPurchase(@Param("order_tracking_number") String orderTracking);
}
