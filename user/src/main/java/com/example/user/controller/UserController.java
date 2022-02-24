package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import com.example.user.controller.DTO.UserDTO;

//importação de class

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/users")
@RestController()
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> lista(@RequestHeader("Authorization") String token) {
        return userRepository.findAll();
    }
     @GetMapping("/{username}")
    public ResponseEntity<Optional<UserDTO>> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userService.findByUsername(username)) ;
    } 
    @PostMapping
    public User adicionar(@RequestBody User user) {
        return userRepository.save(user); 
    }
}