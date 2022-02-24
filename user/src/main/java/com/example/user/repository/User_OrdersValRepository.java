/* package com.example.user.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.user.model.User_Orders;

import org.springframework.stereotype.Repository;

@Repository
public class User_OrdersValRepository {
    
    private final EntityManager em;

    public User_OrdersValRepository(EntityManager em) {this.em = em; }

    public List<User_Orders> find (Long id_order) {
        String query = "SELECT us User_Orders.id_order, User.username from User_Orders as us inner join User as u";
        String condicao = "on";

    }
 
}
 */