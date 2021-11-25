package com.active.edge.stock.api.activedge.config;

import com.active.edge.stock.api.activedge.entity.Stock;
import com.active.edge.stock.api.activedge.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ApplicationRunner called");
        this.addStockToDB();


    }

    public void addStockToDB(){
        List<Stock> stocks;
        stocks= Stream.of(new Stock(1L, "Mobile Stock",20000D, new Date(), new Date())
                        ,new Stock(2L, "Bitcoin Stock",50000D,new Date(), new Date())
                        ,new Stock(3L, "Grain Stock",40000D,new Date(), new Date()))
                .collect(Collectors.toList());
        stockRepository.saveAll(stocks);

    }
}