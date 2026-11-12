package com.ttknpdev.ecomercebackend.repositories.purchase;

import com.ttknpdev.ecomercebackend.entities.purchase.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    // *** behind the scenes : select * from customer c where c.email = email
    Customer findByEmail(String email);
}
