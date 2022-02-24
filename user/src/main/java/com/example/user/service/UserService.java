package com.example.user.service;

import java.util.Optional;

import com.example.user.controller.DTO.UserDTO;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserSerivce { 

    @Autowired
    UserRepository userRepository;

    public Optional <UserDTO> findByUsername (String username){
        Optional <User> user = userRepository.findByUsername(username);
        Optional <UserDTO> userDTO = user.map(dto -> new UserDTO(dto));
        return userDTO;

        
    }


    
}
