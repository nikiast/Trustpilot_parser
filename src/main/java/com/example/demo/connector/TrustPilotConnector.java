package com.example.demo.connector;

import com.example.demo.model.exeption.DomainNotFoundException;
import com.example.demo.model.exeption.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Log4j2
@RequiredArgsConstructor
public class TrustPilotConnector implements Connector{

  private final WebClient webClient;

  public Flux<DataBuffer> getPage(String uri) {
    return webClient.get()
        .uri(uri)
        .retrieve()
        .onStatus(HttpStatusCode::isError, response -> {
          log.error("Error response from domain {}: {}", uri, response.statusCode());
          throw new DomainNotFoundException(new ErrorResponse(uri, response.statusCode()));
        })
        .bodyToFlux(DataBuffer.class);
  }
}
