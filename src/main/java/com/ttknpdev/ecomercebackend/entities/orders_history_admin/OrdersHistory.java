package com.ttknpdev.ecomercebackend.entities.orders_history_admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
// @Entity
// @Table(name = "orders")
@Getter
@Setter
@Data
@AllArgsConstructor
public class OrdersHistory implements Serializable {
    // *** I got a bug when query
    /*
        Bug look like

        In the DB you can see after query :

        1; ID: 111, Name : AAA

        2; ID: 111, Name : BBB

        3; ID: 111, Name : CCC

        The result will be 3 rows retrieved by JPA **** it's same fields :

        1; ID: 111 Name: AAA

        1; ID: 111 Name: AAA

        1; ID: 111 Name: AAA

        ** The answer is, that if there is a @Id annotation in your entity JPA will threat those rows with the given id as a unique element.
        ** So now i have to change/remove pk
        ** i choose to sku is pk (just change position)
    */
    //  @Id
    private Long oid;
    private String orderTrackingNumber;
    private Integer totalQuantity;
    private BigDecimal totalPrice;
    private String email;
    private String imageUrl;
    private String sku;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private Date dateCreated;
    private Boolean statusPurchase;
    private String qrPurchaseUrl;

    public OrdersHistory(String imageUrl, String sku, String name, Integer quantity, BigDecimal price) {
        this.imageUrl = imageUrl;
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }
}
