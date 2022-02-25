/* package com.example.user.service;


import java.util.Optional;

import com.example.user.controller.DTO.User_Stock_BalancesDTO;


public interface IUserStocksBalancesService {

    Optional<User_Stock_BalancesDTO> findByUsername(String username);

     User_Stock_Balances finByUserAndStock(long id_user, long id_stock);
    
    User_Stock_Balances finByUserAndStock(User_Orders orders);

    User_Stock_Balances finByUserAndStock(long id_user);

    List<User_Stock_Balances[]> finByEmail(String email);

    ResponseEntity<?> updateStockUser(long id_user, long id_stock, long volume);
    
    User_Stock_Balances save(User_Stock_Balances balances);
 


    
}
 */