package com.example.demo.model.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainNotFoundException extends RuntimeException {

    private final ErrorResponse errorResponse;
}
