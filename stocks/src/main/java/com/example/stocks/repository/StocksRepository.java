package com.example.stocks.repository;


import java.util.List;

import com.example.stocks.model.Stocks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stocks,Long> {
   
    @Query(value =  " select * from stocks s where stock_name = ?1  " , nativeQuery = true)
    List<Stocks> FindStockName(String stock_name);
}
