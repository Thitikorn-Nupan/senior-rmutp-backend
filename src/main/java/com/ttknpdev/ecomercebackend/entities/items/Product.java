package com.ttknpdev.ecomercebackend.entities.items;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private Integer unitInStock;

    @ManyToOne
    @JoinColumn(name = "pc_id",nullable = false)
    @JsonIgnore
    private ProductCategory productCategory; // map to @OneToMany

}
