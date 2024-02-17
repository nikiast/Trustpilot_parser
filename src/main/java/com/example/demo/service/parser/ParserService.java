package com.example.demo.service.parser;

import com.example.demo.model.ParsingResult;
import reactor.core.publisher.Mono;

public interface ParserService {

  Mono<ParsingResult> parseHtml(String html);
}
