package com.example.demo.service.parser;

import com.example.demo.model.ParsingResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DefaultTrustPilotParserService implements ParserService {

  @Value("${rating.attribute}")
  private String ratingAttribute;
  @Value("${reviews.attribute}")
  private String reviewsAttribute;
  private static final String REGEX_DIGITS = "[^0-9]";
  private static final int ZERO = 0;

  @Override
  public Mono<ParsingResult> parseHtml(String html) {
    return Mono.fromCallable(() -> {
      Document document = Jsoup.parse(html);
      String rating = document.getElementsByAttribute(ratingAttribute)
          .get(ZERO)
          .text();
      String reviews = document.getElementsByClass(reviewsAttribute)
          .get(ZERO)
          .text()
          .replaceAll(REGEX_DIGITS, "");
      return new ParsingResult(Integer.parseInt(reviews), Float.parseFloat(rating));
    });
  }
}
