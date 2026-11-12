package com.ttknpdev.ecomercebackend.services.items;

import com.ttknpdev.ecomercebackend.entities.items.ProductCategory;
import com.ttknpdev.ecomercebackend.repositories.items.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    public ProductCategoryService(ProductCategoryRepo productCategoryRepo) {
        this.productCategoryRepo = productCategoryRepo;
    }

    public Iterable<ProductCategory> getAllProductCategories() {
        return productCategoryRepo.findAll();
    }

}
