package com.example.user.controller.DTO;

import java.math.BigDecimal;

import com.example.user.model.User;
import com.example.user.model.User_Orders;

import lombok.Data;

@Data
public class User_OrdersDTO {

    private Long id;
    private Long id_user;
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private Integer volume;
    private Integer volume_remaining;
    private BigDecimal price;
    private Integer type;
    private Integer status;

    public User_Orders codigo(User user){
        return new User_Orders(
                user,
                id_user,
                id_stock,
                stock_symbol,
                stock_name,
                price,
                type,
                status,
                volume,
                volume_remaining);
    } 
}
