package com.example.TestTaskSovkombank.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class ControllerExceptionHandler
{
    @ExceptionHandler(ImageException.class)
    public ResponseEntity<String> handleInterruptedExceptionException(Exception ex)
    {
        log.atError().log(ex.getMessage());
        return new ResponseEntity<>("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
