package com.example.demo.service.connector;

import reactor.core.publisher.Mono;

public interface ConnectorService {

  Mono<String> getDomain(String domain);
}
