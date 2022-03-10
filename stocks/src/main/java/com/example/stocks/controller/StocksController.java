package com.example.stocks.controller;

//importação de class
import java.util.List;
import java.util.Optional;

import com.example.stocks.model.Stocks;
import com.example.stocks.repository.StocksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    @Autowired
    StocksRepository stocks_Repository;

    @GetMapping
    public List<Stocks> listastocks(@RequestHeader("Authorization") String token) {
        return stocks_Repository.findAll();
    }

 /*    @GetMapping("/{id}")
    public Optional<Stocks> stocksID(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        return stocks_Repository.findById(id);
    } */
    @GetMapping("/{stock_name}")
    public List <Stocks> list(@PathVariable ("stock_name")String stock_name){
        return stocks_Repository.FindStockName(stock_name);
    }
}