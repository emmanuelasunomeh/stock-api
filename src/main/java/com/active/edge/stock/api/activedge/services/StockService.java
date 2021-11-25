package com.active.edge.stock.api.activedge.services;


import com.active.edge.stock.api.activedge.dto.StockDTO;
import com.active.edge.stock.api.activedge.entity.Stock;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockService {

    List<Stock> getAllStocks();
    Stock getStockById(Long Id);
    Stock updateStock(StockDTO stockUpdateDTO);
    void deleteById(Long Id);
    Stock createStock(Stock stock);

}
