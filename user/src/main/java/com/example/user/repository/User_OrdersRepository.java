package com.example.user.repository;

import java.util.List;

import com.example.user.model.User_Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface User_OrdersRepository extends JpaRepository<User_Orders, Long>  {//<<<mudei

/*     @Query("SELECT User_Orders.id_stock, User.username from User_Orders uo join User on uo.id_user = :id")
    public List<User_Orders> find(@Param("id_stock") Long id_stock);
     */
        @Query(value = "SELECT * FROM user_orders  WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<User_Orders> findByOrders(Long id_stock);
      
}
