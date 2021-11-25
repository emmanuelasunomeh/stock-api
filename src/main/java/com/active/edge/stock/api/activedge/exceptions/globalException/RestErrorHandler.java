package com.active.edge.stock.api.activedge.exceptions.globalException;

import com.active.edge.stock.api.activedge.exceptions.StockNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@Slf4j
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StockNotFoundException.class)
    ResponseEntity<?> noRecordFound(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage()==null?"NO RECORD FOUND":ex.getMessage())
                .entity();
    }


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<?> handleExceptions(Exception ex, WebRequest request) {
        logger.error(ex.getLocalizedMessage(), ex);
        return RestResponse.builder()
                .status(SERVICE_UNAVAILABLE)
                .message("Server Unavailable Try again: "+ex)
                .entity();
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        logger.error(ex.getLocalizedMessage(), ex);
        return RestResponse.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message("Server encountered an error: "+ex)
                .entity();
    }

}