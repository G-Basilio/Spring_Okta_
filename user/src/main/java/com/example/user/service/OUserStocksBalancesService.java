package com.example.user.service;

import java.util.List;

import com.example.user.model.User_Orders;
import com.example.user.model.User_Stock_Balances;

import org.springframework.http.ResponseEntity;


public interface OUserStocksBalancesService {

    User_Stock_Balances finByUserAndStock(long id_user, long id_stock);
    
    User_Stock_Balances finByUserAndStock(User_Orders orders);

    User_Stock_Balances finByUserAndStock(long id_user);

    List<User_Stock_Balances[]> finByEmail(String email);

    ResponseEntity<?> updateStockUser(long id_user, long id_stock, long volume);
    
    User_Stock_Balances save(User_Stock_Balances balances);



    
}
