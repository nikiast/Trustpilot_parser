package com.example.demo.config;

import com.example.demo.connector.Connector;
import com.example.demo.connector.TrustPilotConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConnectorConfig {

  @Value("${trust.pilot.url}")
  private String trustPilotUrl;

  @Bean
  public WebClient trutPilotWebClient() {
    return WebClient.builder()
        .baseUrl(trustPilotUrl)
        .build();
  }

  @Bean
  public Connector trustPilotConnector() {
    return new TrustPilotConnector(trutPilotWebClient());
  }
}
