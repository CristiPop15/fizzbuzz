package com.fizzbuzz.test;

import com.fizzbuzz.parser.FizzBuzzParser;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzParserTest {

  private FizzBuzzParser sut = new FizzBuzzParser();

  @Test
  public void fizzBuzzParseTest() {
    Assert.assertEquals("1", sut.parse(1));
    Assert.assertEquals("2", sut.parse(2));
    Assert.assertEquals("alfresco", sut.parse(3));
    Assert.assertEquals("buzz", sut.parse(5));
    Assert.assertEquals("fizzbuzz", sut.parse(15));

    Assert.assertEquals("alfresco", sut.parse(153));
  }
}
