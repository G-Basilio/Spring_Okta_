package com.example.user.controller.DTO;

import com.example.user.model.IdUserStocks;
import com.example.user.model.User;
import com.example.user.model.User_Stock_Balances;

import lombok.Data;

@Data
public class User_Stock_BalancesDTO {
    
    private Long id_user;
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private Integer volume;


    public User_Stock_Balances userStocksObj (User user){
        return new User_Stock_Balances(
            new IdUserStocks(user, id_stock),
            stock_symbol,
            stock_name,
            volume
        );

    }
    public User_Stock_BalancesDTO() {
    }

/*      public User_Stock_BalancesDTO(Long id_user, Long id_stocks, String stock_symbol, String stock_name,
            Integer volume) {
        this.id_user = id_user;
        this.id_stock = id_stocks;
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.volume = volume;
    }
 */
    public User_Stock_BalancesDTO(User_Stock_Balances user_Stock_Balances) {
     this.id_user =id_user;
     this.stock_symbol = stock_symbol;
     this.stock_name = stock_name;
     this.volume = volume;
    }
    

 
    
  
    
}
