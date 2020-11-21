package com.fizzbuzz.test;

import com.fizzbuzz.parser.NumberParser;
import org.junit.Assert;
import org.junit.Test;

public class NumberParserTest {

  private NumberParser sut = new NumberParser();

  @Test
  public void containsDigitTest() {
    int digitToCheck = 3;

    Assert.assertTrue(sut.containsDigit(3, digitToCheck));
    Assert.assertTrue(sut.containsDigit(131, digitToCheck));
    Assert.assertTrue(sut.containsDigit(100031, digitToCheck));
    Assert.assertTrue(sut.containsDigit(30003, digitToCheck));

    Assert.assertFalse(sut.containsDigit(111, digitToCheck));
    Assert.assertFalse(sut.containsDigit(10000, digitToCheck));
    Assert.assertFalse(sut.containsDigit(1245677989, digitToCheck));
  }

}
