package com.fizzbuzz.parser;

import com.fizzbuzz.metric.MetricsMonitoring;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class FizzBuzzParserService {

  @Autowired
  private NumberParser numberParser;

  @Autowired
  private MetricsMonitoring metrics;

  public String convert(String[] numbers) {
    if (numbers == null) {
      return "";
    }

    return Stream.of(numbers).map(number -> parse(Integer.parseInt(number)))
        .collect(Collectors.joining(" "));
  }

  private String parse(int number) {
    if (numberParser.containsDigit(number, 3)) {
      metrics.addAlfresco();

      return "alfresco";
    }

    if (number % 15 == 0) {
      metrics.addFizzbuzz();

      return "fizzbuzz";
    }

    if (number % 3 == 0) {
      metrics.addFizz();

      return "fizz";
    }

    if (number % 5 == 0) {
      metrics.addBuzz();

      return "buzz";
    }

    metrics.addNumber();
    return String.valueOf(number);
  }

  public String printMetrics() {
    return metrics.toString();
  }
}
