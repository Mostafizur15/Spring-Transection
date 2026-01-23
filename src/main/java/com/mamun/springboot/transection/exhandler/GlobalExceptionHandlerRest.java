package com.mamun.springboot.transection.exhandler;

import com.mamun.springboot.transection.exception.DataAccessError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerRest {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> defaultExHandler(Throwable ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "timestamp", Instant.now(),
                "error", ex.getMessage()
        ));
    }
    @ExceptionHandler(DataAccessError.class)
    public ResponseEntity<?> dataAccessError(DataAccessError error){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
           "timestamp", Instant.now(),
                "error", error.getMessage()
        ));
    }
}
