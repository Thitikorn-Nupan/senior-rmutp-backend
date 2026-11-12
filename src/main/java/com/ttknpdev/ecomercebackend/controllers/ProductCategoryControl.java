package com.ttknpdev.ecomercebackend.controllers;


import com.ttknpdev.ecomercebackend.entities.items.ProductCategory;
import com.ttknpdev.ecomercebackend.services.items.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/product-category")
public class ProductCategoryControl {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryControl(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    // for retrieving name categories
    @GetMapping
    public ResponseEntity<Iterable<ProductCategory>> reads() {
        return ResponseEntity
                .accepted()
                .body(this.productCategoryService.getAllProductCategories());
    }
}
