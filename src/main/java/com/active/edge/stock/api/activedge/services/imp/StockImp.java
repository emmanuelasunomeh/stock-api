package com.active.edge.stock.api.activedge.services.imp;


import com.active.edge.stock.api.activedge.dto.StockDTO;
import com.active.edge.stock.api.activedge.entity.Stock;
import com.active.edge.stock.api.activedge.exceptions.StockNotFoundException;
import com.active.edge.stock.api.activedge.repository.StockRepository;
import com.active.edge.stock.api.activedge.services.StockService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Component
public class StockImp implements StockService {

    private final StockRepository stockRepo;

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stockList = Optional.ofNullable(stockRepo.findAll()).orElse(new ArrayList<>());
        if(stockList.size()==0){
            throw new StockNotFoundException("NO STOCK FOUND");
        }
        return stockList;

    }

    @Override
    public Stock getStockById(Long Id) {
//        Throw NoParameterFoundException
        if(null==Id){return null;}
//        Throw NoRecordFoundException
        Stock stock = stockRepo.findById(Id).orElseThrow(() ->new StockNotFoundException("UNABLE TO GET STOCK WITH ID: "+Id));
        return stock;
    }

    @Override
    public Stock updateStock(StockDTO stockUpdateDTO) {
        Stock stock = stockRepo.findById(stockUpdateDTO.getId()).orElseThrow(() ->new StockNotFoundException("UNABLE TO GET STOCK WITH ID: "+stockUpdateDTO.getId()));
        stock.setCurrent_price(stockUpdateDTO.getCurrent_price());
        stock.setName(stockUpdateDTO.getName());
        Stock updatedStock = stockRepo.save(stock);
        return updatedStock;
    }

    @Override
    public void deleteById(Long Id) {
        if(!stockRepo.existsById(Id)){
            throw new StockNotFoundException("No Record Found For ID: "+Id);
        }
        stockRepo.deleteById(Id);
    }

    @Override
    public Stock createStock(Stock stock) {
        Stock savedStock = stockRepo.save(stock);
        return savedStock;
    }
}
