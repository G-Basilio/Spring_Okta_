package com.example.stocks.repository;


import com.example.stocks.model.Stocks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stocks,Long> {
    
}
