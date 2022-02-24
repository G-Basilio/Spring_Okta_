package com.example.user.service;

import java.util.Optional;

import com.example.user.controller.DTO.UserDTO;

public interface IUserSerivce {
    
    Optional<UserDTO> findByUsername(String username);

    
}
