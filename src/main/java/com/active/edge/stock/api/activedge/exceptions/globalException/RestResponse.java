package com.active.edge.stock.api.activedge.exceptions.globalException;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private String message;
//    // getters, setters, etc.
    public static RestResponseBuilder builder() {
        return new RestResponseBuilder();
    }

}
