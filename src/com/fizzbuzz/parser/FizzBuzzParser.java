package com.fizzbuzz.parser;

import com.fizzbuzz.metric.MetricsMonitoring;

public class FizzBuzzParser {

  private NumberParser numberParser = new NumberParser();
  private MetricsMonitoring metrics;

  public FizzBuzzParser(MetricsMonitoring metrics) {
    this.metrics = metrics;
  }

  public String parse(int number) {
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
}
