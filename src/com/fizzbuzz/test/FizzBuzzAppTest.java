package com.fizzbuzz.test;

import com.fizzbuzz.FizzBuzzApp;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzAppTest {

  private FizzBuzzApp sut = new FizzBuzzApp();

  @Test
  public void convertTest_pass() {
    Assert.assertEquals("1 2 fizz 4 buzz",
        sut.convert(new String[]{"1", "2", "3", "4", "5"}));
    Assert.assertEquals("1 2 fizz 4 buzz 7 fizzbuzz",
        sut.convert(new String[]{"1", "2", "3", "4", "5", "7", "15"}));
    Assert.assertEquals("fizz buzz fizzbuzz fizzbuzz buzz fizzbuzz fizz",
        sut.convert(new String[]{"3", "5", "15", "30", "25", "90", "66"}));
  }

  @Test()
  public void convertTest_null() {
    Assert.assertEquals("", sut.convert(null));
  }

  @Test(expected = NumberFormatException.class)
  public void convertTest_StringParseError() {
    sut.convert(new String[]{"String"});
  }
}
