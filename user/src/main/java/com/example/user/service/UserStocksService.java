package com.example.user.service;

import com.example.user.controller.DTO.User_Stock_BalancesDTO;
import com.example.user.model.User_Stock_Balances;
import com.example.user.repository.User_Stock_BalancesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RestController
public class UserStocksService {

    @Autowired
    private User_Stock_BalancesRepository user_Stock_BalancesRepository;

    @Autowired
    private WebClient webClientStocks;

    @GetMapping
    public User_Stock_BalancesDTO codigo(Long id,@RequestHeader("Authorization") String token) {
        Mono<User_Stock_BalancesDTO> monoStock = this.webClientStocks
        .method(HttpMethod.GET) 
        .uri( "/stocks/{id}", id)
        .header(HttpHeaders.AUTHORIZATION, token)
        .retrieve()
        .bodyToMono(User_Stock_BalancesDTO.class);

        monoStock.subscribe(s -> {
            System.out.println("Aqui é o UserStocksService");
        });
        User_Stock_BalancesDTO user_Stock_BalancesDTO = monoStock.block();
        return user_Stock_BalancesDTO;
    }
    
    public User_Stock_Balances add(User_Stock_Balances user_Stock_Balances){
        return user_Stock_BalancesRepository.save(user_Stock_Balances);
    }

    
    public User_Stock_Balances SalvarId(Long id,@RequestHeader("Authorization") String token) {
        Mono<User_Stock_Balances> monoStock = this.webClientStocks
        .method(HttpMethod.POST) 
        .uri( "/stocks/{id}", id)
        .header(HttpHeaders.AUTHORIZATION, token)
        .retrieve()
        .bodyToMono(User_Stock_Balances.class);
        monoStock.subscribe(s -> {
        });
        User_Stock_Balances stock_Balances = monoStock.block();
        return stock_Balances;
    } 
}
 