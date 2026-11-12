package com.ttknpdev.ecomercebackend.services.items;


import com.ttknpdev.ecomercebackend.entities.items.Product;
import com.ttknpdev.ecomercebackend.repositories.items.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProductsByProductCategoryName(String name) {
        return this.productRepo.findByProductCategoryCategoryName(name);
    }

    public List<Product> getAllProductsByProductCategoryId(long pc_id) {
        return this.productRepo.findByProductCategoryId(pc_id);
    }

    public List<Product> getAllProductsByName(String name) {
        return this.productRepo.findByNameContaining(name);
    }

    public Optional<Product> getProductById(long pid) {
        return this.productRepo.findById(pid);
    }

    public void updateUnitInStock(int quantity , long pid) {
        this.productRepo.decrementUnitInStock(quantity, pid);
    }
}
