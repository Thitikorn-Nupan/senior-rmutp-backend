package com.ttknpdev.ecomercebackend.repositories.items;

import com.ttknpdev.ecomercebackend.entities.items.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> { }
