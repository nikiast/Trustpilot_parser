package com.example.demo.connector;

import org.springframework.core.io.buffer.DataBuffer;
import reactor.core.publisher.Flux;

public interface Connector {

  Flux<DataBuffer> getPage(String uri);
}
