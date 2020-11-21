package com.fizzbuzz;

import com.fizzbuzz.parser.FizzBuzzParser;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzzApp {

  private FizzBuzzParser fizzBuzzParser = new FizzBuzzParser();

  public String convert(String[] numbers) {
    if (numbers == null) {
      return "";
    }

    return Stream.of(numbers).map(number -> fizzBuzzParser.parse(Integer.parseInt(number)))
        .collect(Collectors.joining(" "));
  }
}
