package com.example.demo.controller.handler;

import com.example.demo.model.exeption.DomainNotFoundException;
import com.example.demo.model.exeption.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TrustPilotHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(DomainNotFoundException.class)
  protected ResponseEntity<ErrorResponse> handleNotFoundException(DomainNotFoundException ex) {
    return ResponseEntity
        .status(ex.getErrorResponse().status())
        .body(ex.getErrorResponse());
  }
}
