package com.example.demo.service;

import com.example.demo.model.ParsingResult;
import com.example.demo.service.connector.ConnectorService;
import com.example.demo.service.parser.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultDomainParsingService {

  private final ConnectorService connectorService;
  private final ParserService parserService;

  @Cacheable("parseCache")
  public Mono<ParsingResult> parseDomain(String domain) {
    return connectorService.getDomain(domain)
        .flatMap(parserService::parseHtml);
  }
}
