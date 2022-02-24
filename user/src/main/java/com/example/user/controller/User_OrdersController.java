package com.example.user.controller;

import java.util.List;
import com.example.user.controller.DTO.User_OrdersDTO;
import com.example.user.model.User;
import com.example.user.model.User_Orders;
import com.example.user.repository.UserRepository;
import com.example.user.repository.User_OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/user_orders") 
public class User_OrdersController {

    @Autowired 
    User_OrdersRepository user_OrdersRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<User_Orders> listOrders() {
        return user_OrdersRepository.findAll(); 
    }

    @PostMapping
    public User_Orders add(@RequestBody User_Orders user_Orders) { 

        return user_OrdersRepository.save(user_Orders); 
    }
   
    @GetMapping("/filtro")
    public List<User_Orders> listar(
        @RequestHeader("Authorization") String token,
            @RequestBody User_OrdersDTO user_OrdersDTO) {
        return user_OrdersRepository.findByOrders(user_OrdersDTO.getId_stock());
    }//testar
    @PostMapping("/order")
    public ResponseEntity<User_Orders> salvarStock2(@RequestBody User_OrdersDTO user_OrdersDTO) {
        User user = userRepository.findById(user_OrdersDTO.getId_user()).orElseThrow();
        User_Orders user_Orders = user_OrdersDTO.codigo(user);
        return new ResponseEntity<>(user_OrdersRepository.save(user_Orders), HttpStatus.CREATED);
    }
}