package com.example.user.repository;

import java.util.Optional;

import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //usar por que ja tem varios metodos como save, delete etc...
     
    Optional<User> findByUsername(String username);
    //User findBydolar_balance(BigDecimal dolar_balance); 
    //Optional<User> findByUsername(String username);
}
