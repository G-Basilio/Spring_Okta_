package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import com.example.user.controller.DTO.User_Stock_BalancesDTO;
import com.example.user.model.User;
import com.example.user.model.User_Stock_Balances;
import com.example.user.repository.UserRepository;
import com.example.user.repository.User_Stock_BalancesRepository;
import com.example.user.service.UserStocksBalancesService;
import com.example.user.service.UserStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/stocks")
public class User_Stock_BalancesController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    User_Stock_BalancesRepository stock_B_Repository;
    @Autowired
    UserStocksService userStocksService;
    @Autowired
    WebClient webClient;
    @Autowired
    UserStocksBalancesService userStocksBalancesService;

    @GetMapping("todos")
    public List<User_Stock_Balances> listStock() {
        return stock_B_Repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_Stock_BalancesDTO> codigo(@PathVariable Long id,
            @RequestHeader("Authorization") String token) {
        User_Stock_BalancesDTO user_Stock_BalancesDTO = this.userStocksService.codigo(id, token);
        return ResponseEntity.ok(user_Stock_BalancesDTO);
    }
/*     @GetMapping("/{id_user}")
    public ResponseEntity<Optional<User_Stock_BalancesDTO>> findById(@PathVariable("id_user") Long id_user){
        return ResponseEntity.ok().body(userStocksBalancesService.findById(id_user)) ;
    } */

    @PostMapping("/add")
    public ResponseEntity<User_Stock_Balances> add(@RequestBody User_Stock_BalancesDTO user_Stock_BalancesDTO) {
        User user = userRepository.findById(user_Stock_BalancesDTO.getId_user()).orElseThrow();
        User_Stock_Balances user_Stock_Balances = userStocksService.add(user_Stock_BalancesDTO.userStocksObj(user));
        return new ResponseEntity<>(user_Stock_Balances, HttpStatus.CREATED);
    }
    
       @PostMapping("{id}")
      public User_Stock_Balances SalvarId(@PathVariable Long id,
      @RequestHeader("Authorization")String token){
      User_Stock_Balances user_Stock_Balances = this.userStocksService.SalvarId(id,
      token);
      return stock_B_Repository.save(user_Stock_Balances);
      } 
     

}