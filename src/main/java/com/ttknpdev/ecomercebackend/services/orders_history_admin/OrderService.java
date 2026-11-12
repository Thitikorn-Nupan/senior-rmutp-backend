package com.ttknpdev.ecomercebackend.services.orders_history_admin;


import com.ttknpdev.ecomercebackend.entities.orders_history_admin.OrdersHistory;
import com.ttknpdev.ecomercebackend.entities.purchase.Order;
// import com.ttknpdev.ecomercebackend.repositories.orders_history_admin.OrdersHistoryRepo;
import com.ttknpdev.ecomercebackend.repositories.purchase.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements RowCallbackHandler {

    private final String SQL_JOIN_FOUR_TABLE = "" +
            "SELECT o.oid , o.order_tracking_number , o.total_price , o.total_quantity , o.date_created , o.status_purchase , o.qr_purchase_url ," +
            "c.email , " +
            "oi.image_url , oi.quantity , oi.price ," +
            "p.sku , p.name " +
            "from orders as o " +
            "join customers as c " +
            "on o.customer_cid = c.cid " +
            "join order_items as oi " +
            "on o.oid = oi.order_oid " +
            "join products as p " +
            "on oi.product_pid = p.pid " +
            "order by o.date_created desc";


    private final String SQL_JOIN_TABLE = "select " +
            "p.sku, p.name, " +
            "o.image_url , sum(o.quantity) as quantity , o.price " +
            "from order_items as o " +
            "join products as p " +
            "on o.product_pid = p.pid " +
            "group by p.sku, p.name, o.image_url, o.price " +
            "having (sum(o.quantity))";


    private OrderRepo orderRepo;
    private JdbcTemplate jdbcTemplate;
    private List<OrdersHistory> ordersHistoryList;

    @Autowired
    public OrderService(OrderRepo orderRepo,
                        JdbcTemplate jdbcTemplate) {
        this.orderRepo = orderRepo;
        this.jdbcTemplate = jdbcTemplate;
        ordersHistoryList = new ArrayList<>();
    }
    public List<Order> getOrdersByCustomerEmail(String email) {
        return this.orderRepo.findByCustomerEmailOrderByDateCreatedDesc(email);
    }
    /*
    Does not work!! i have to change to jdbc for query
    @Transactional
    public List<OrdersHistory> getOrders () {
        return this.ordersHistoryRepo.findAllOrders();
    }
    */

    public List<OrdersHistory> getOrders() {
        ordersHistoryList.clear();
        jdbcTemplate.query(SQL_JOIN_FOUR_TABLE, this::processRow);
        return ordersHistoryList;
    }

    public List<OrdersHistory> getOrdersOnlyPerfumes() {
        ordersHistoryList.clear();
        jdbcTemplate.query(SQL_JOIN_TABLE,resultSet -> {
            OrdersHistory ordersHistory = new OrdersHistory(
                    resultSet.getString("image_url"),
                    resultSet.getString("sku"),
                    resultSet.getString("name"),
                    resultSet.getInt("quantity"),
                    resultSet.getBigDecimal("price")
            );
            ordersHistoryList.add(ordersHistory);
        });
        return ordersHistoryList;
    }

    public Boolean updateStatusPurchaseByOrderTrackingNumber(String orderTrackingNumber) {
        try {
            orderRepo.updateStatusPurchase(orderTrackingNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void processRow(ResultSet resultSet) throws SQLException {
        OrdersHistory ordersHistory = new OrdersHistory(
                resultSet.getLong("oid"),
                resultSet.getString("order_tracking_number"),
                resultSet.getInt("total_quantity"),
                resultSet.getBigDecimal("total_price"),
                resultSet.getString("email"),
                resultSet.getString("image_url"),
                resultSet.getString("sku"),
                resultSet.getString("name"),
                resultSet.getInt("quantity"),
                resultSet.getBigDecimal("price"),
                resultSet.getDate("date_created"),
                resultSet.getBoolean("status_purchase"),
                resultSet.getString("qr_purchase_url")
        );
        ordersHistoryList.add(ordersHistory);
    }



}
