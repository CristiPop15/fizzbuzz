package com.fizzbuzz;

import com.fizzbuzz.metric.MetricsMonitoring;
import com.fizzbuzz.parser.FizzBuzzParser;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzzApp {

  private String[] numbers;
  private MetricsMonitoring metrics;
  private FizzBuzzParser fizzBuzzParser;

  public FizzBuzzApp(String[] numbers) {
    this.numbers = numbers;
    this.metrics = new MetricsMonitoring();
    this.fizzBuzzParser = new FizzBuzzParser(metrics);
  }

  public String convert() {
    if (numbers == null) {
      return "";
    }

    return Stream.of(numbers).map(number -> fizzBuzzParser.parse(Integer.parseInt(number)))
        .collect(Collectors.joining(" "));
  }

  public String printMetrics() {
    return metrics.toString();
  }
}
