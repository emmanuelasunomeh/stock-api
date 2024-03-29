package com.active.edge.stock.api.activedge.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException() {
        super();
    }
    public StockNotFoundException(String message) {
        super(message);
    }


}