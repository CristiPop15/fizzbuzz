package com.fizzbuzz.parser;

public class FizzBuzzParser {

  private NumberParser numberParser = new NumberParser();

  public String parse(int number) {
    if(numberParser.containsDigit(number, 3)) {
      return "alfresco";
    }

    if (number % 15 == 0) {
      return "fizzbuzz";
    }

    if (number % 3 == 0) {
      return "fizz";
    }

    if (number % 5 == 0) {
      return "buzz";
    }

    return String.valueOf(number);
  }
}
