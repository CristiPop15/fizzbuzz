package com.fizzbuzz.parser;

import org.springframework.stereotype.Service;

@Service
public class NumberParser {

  public boolean containsDigit(int number, int digitToCheck) {
    do {
      int mod = number % 10;

      if (mod == digitToCheck) {
        return true;
      }
    } while((number = number/10) > 0);

    return false;
  }
}
