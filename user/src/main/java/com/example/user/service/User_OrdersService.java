/*  package com.example.user.service;

import com.example.user.model.User_Orders;
import com.example.user.repository.User_OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class User_OrdersService implements  OUserStocksBalancesService{

    OUserStocksBalancesService oUserStocksBalancesService;

    @Autowired
    private User_OrdersRepository user_OrdersRepository;

    @Override
    public ResponseEntity<?> save(User_Orders user_Orders, String token) {

        if (user_Orders.getType() == 2 && confirmacao(user_Orders)){
            user_OrdersRepository.save(user_Orders);
        } else if (user_Orders.getType() == 1) {
            user_OrdersRepository.save(user_Orders);
        }
    }

    public boolean confirmacao(User_Orders user_Orders){
        if(oUserStocksBalancesService.finByUserAndStock(user_Orders.getId_user(), user_Orders.getId_stock())
        .getVolume() >= user_Orders.getVolume()){
            return true;
        } else {
            return false;
        }
     }
    
}
  */