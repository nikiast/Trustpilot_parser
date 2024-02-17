package com.example.demo.controller;

import com.example.demo.model.ParsingResult;
import com.example.demo.service.DefaultDomainParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TrustPilotController {

    private final DefaultDomainParsingService parserService;

    @GetMapping("/reviews/{domain}")
    public Mono<ParsingResult> getParsingResponse(@PathVariable String domain) {
        return parserService.parseDomain(domain);
    }
}
