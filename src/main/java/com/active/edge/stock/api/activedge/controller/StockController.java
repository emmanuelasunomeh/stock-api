package com.active.edge.stock.api.activedge.controller;


import com.active.edge.stock.api.activedge.dto.StockDTO;
import com.active.edge.stock.api.activedge.entity.Stock;
import com.active.edge.stock.api.activedge.services.StockService;
import com.active.edge.stock.api.activedge.util.JsonResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;


//    GET /api/stocks … (get the List of Stocks)
    @GetMapping()
    public ResponseEntity<?> getStockList() {
        List<Stock> stockList = stockService.getAllStocks();
        return new ResponseEntity<>(stockList, HttpStatus.OK);
    }


//    GET /api/stocks/1 … (get a single Stock from the list by its ID)
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStockById(@PathVariable Long id) {
        Stock stock = stockService.getStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

//    PUT /api/stocks/1 … (update the current_price/name of a single Stock)
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateStockById(@RequestBody StockDTO stockDTO) {
        Stock updatedStock = stockService.updateStock(stockDTO);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

//    DELETE /api/stocks/1 … (delete a single Stock by its ID)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteStockById(@PathVariable Long id) {
         stockService.deleteById(id);
        return new ResponseEntity<>(new JsonResponse("Successfully deleted Stock by ID: "+id), HttpStatus.OK);
    }

//    POST /api/stocks … (create a new Stock)
    @Transactional(readOnly = true)
    @PostMapping()
    public ResponseEntity<?> createStock(@RequestBody Stock stock) {
        Stock savedStock = stockService.createStock(stock);
        return ResponseEntity.ok(savedStock);
    }


}
