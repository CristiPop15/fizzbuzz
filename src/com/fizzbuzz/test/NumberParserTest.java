package com.fizzbuzz.test;

import com.fizzbuzz.parser.NumberParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberParserTest {

  @Autowired
  private NumberParser sut;

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
