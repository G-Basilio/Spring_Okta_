package com.example.user.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "user_stock_balances")

public class User_Stock_Balances {
    
    @EmbeddedId
    private IdUserStocks userStokcks;
    private String stock_symbol;
    private String stock_name;
    private Integer volume;
    private Timestamp created_on;
    private Timestamp updated_on;

    public void setUserStokcks(IdUserStocks userStokcks) {
        this.userStokcks = userStokcks;
    }
    
    public User_Stock_Balances(IdUserStocks userStokcks, String stock_symbol, String stock_name, Integer volume) {
        this.userStokcks = userStokcks;
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.volume = volume;
        this.created_on = Timestamp.valueOf(LocalDateTime.now());
        this.updated_on = Timestamp.valueOf(LocalDateTime.now());

    }
    public User_Stock_Balances() {
        
    }
}
