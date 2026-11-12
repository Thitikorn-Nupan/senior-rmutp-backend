package com.ttknpdev.ecomercebackend.repositories.items;


import com.ttknpdev.ecomercebackend.entities.items.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    // use auto generate DDL sql in JPA

    List<Product> findByProductCategoryCategoryName(@Param("name") String name);

    List<Product> findByProductCategoryId(@Param("pc_id") long pc_id);

    // *** query by %name suck as a find by keyword
    List<Product> findByNameContaining(@Param("name") String name);

    // *** work before purchase
    @Transactional
    @Modifying
    @Query(value = "update products set unit_in_stock = (unit_in_stock - :quantity) where pid = :pid", nativeQuery = true)
    void decrementUnitInStock(@Param("quantity") int quantity , @Param("pid") long pid);
}
