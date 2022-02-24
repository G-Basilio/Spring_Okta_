package com.example.user.controller.DTO;

import com.example.user.model.User;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private double dollar_balance;
    private boolean enabled;


    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.dollar_balance = user.getDollar_balance();
        this.enabled = user.getEnabled();
    }
    
    
}
