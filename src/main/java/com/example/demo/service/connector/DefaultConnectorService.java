package com.example.demo.service.connector;

import com.example.demo.connector.Connector;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultConnectorService implements ConnectorService{

  private final Connector connector;

  public Mono<String> getDomain(String domain) {
    return connector.getPage(domain)
        .map(dataBuffer -> {
          byte[] bytes = new byte[dataBuffer.readableByteCount()];
          dataBuffer.read(bytes);
          DataBufferUtils.release(dataBuffer);
          return new String(bytes, StandardCharsets.UTF_8);
        })
        .collectList()
        .map(list -> String.join("", list));
  }
}
