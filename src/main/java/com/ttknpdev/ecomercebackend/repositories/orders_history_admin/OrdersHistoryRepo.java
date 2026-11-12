//package com.ttknpdev.ecomercebackend.repositories.orders_history_admin;
//
//import com.ttknpdev.ecomercebackend.entities.orders_history_admin.OrdersHistory;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;

// *** Not work
//public interface OrdersHistoryRepo extends JpaRepository<OrdersHistory, Long> {
//    /*@Query(value =
//            "SELECT o.oid , o.order_tracking_number , o.total_price , o.total_quantity , o.date_created ," +
//            "c.email , " +
//            "oi.image_url , oi.quantity , oi.price ," +
//            "p.sku , p.name " +
//            "from orders as o " +
//            "join customers as c " +
//            "on o.customer_cid = c.cid " +
//            "join order_items as oi " +
//            "on o.oid = oi.order_oid " +
//            "join products as p " +
//            "on oi.product_pid = p.pid " +
//            "order by o.date_created desc ", nativeQuery = true)
//    List<OrdersHistory> findAllOrders();*/
//
//}
