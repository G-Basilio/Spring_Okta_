  package com.example.user.service;

import java.util.List;
import java.util.Optional;

import com.example.user.controller.DTO.User_Stock_BalancesDTO;
import com.example.user.model.User_Orders;
import com.example.user.model.User_Stock_Balances;
import com.example.user.repository.User_Stock_BalancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserStocksBalancesService implements IUserStocksBalancesService {

/*     @Autowired
    User_Stock_BalancesRepository user_Stock_BalancesRepository;

    public Optional <User_Stock_BalancesDTO> findById (Long id_user){
        Optional <User_Stock_Balances> balances = user_Stock_BalancesRepository.findById(id_user);
        Optional <User_Stock_BalancesDTO> balancesDTO = balances.map(dto -> new User_Stock_BalancesDTO(dto));
        return balancesDTO;
    }  */ 
}


     /* @Autowired
    private User_Stock_BalancesRepository user_Stock_BalancesRepository;

    @Override
    public User_Stock_Balances finByUserAndStock(long id_user, long id_stock) {
        if ( user_Stock_BalancesRepository.finByUserAndStock(id_user, id_stock) == null) {
            return new User_Stock_Balances();
        } else {
            return user_Stock_BalancesRepository.finByUserAndStock(id_user, id_stock);
        }
    }

    @Override
    public User_Stock_Balances finByUserAndStockOrder(long id_user) {
        return null;
    }

    @Override
    public List<User_Stock_Balances[]> finByEmail(String email) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateStockUser(long id_user, long id_stock, long volume) {
        return null;
    }

    @Override
    public User_Stock_Balances save(User_Stock_Balances balances) {
        return null;
    }

    @Override
    public User_Stock_Balances finByUserAndStock(User_Orders orders) {
        return null;
    }   */