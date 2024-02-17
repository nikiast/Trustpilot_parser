package com.example.demo.model.exeption;

import org.springframework.http.HttpStatusCode;

public record ErrorResponse(String domain, HttpStatusCode status) {
}
