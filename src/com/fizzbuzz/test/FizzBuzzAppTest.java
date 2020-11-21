package com.fizzbuzz.test;

import com.fizzbuzz.FizzBuzzApp;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzAppTest {

  private FizzBuzzApp sut;

  @Test
  public void convertTest_pass() {
    sut = new FizzBuzzApp(new String[]{"1", "2", "3", "4", "5"});
    Assert.assertEquals("1 2 alfresco 4 buzz",
        sut.convert());

    sut = new FizzBuzzApp(new String[]{"1", "2", "3", "4", "5", "7", "15"});
    Assert.assertEquals("1 2 alfresco 4 buzz 7 fizzbuzz",
        sut.convert());

    sut = new FizzBuzzApp(new String[]{"3", "5", "15", "30", "25", "90", "66", "13"});
    Assert.assertEquals("alfresco buzz fizzbuzz alfresco buzz fizzbuzz fizz alfresco",
        sut.convert());
  }

  @Test()
  public void convertTest_null() {
    sut = new FizzBuzzApp(null);
    Assert.assertEquals("", sut.convert());
  }

  @Test(expected = NumberFormatException.class)
  public void convertTest_StringParseError() {
    sut = new FizzBuzzApp(new String[]{"String"});
    sut.convert();
  }

  @Test
  public void printMetricsTest() {
    sut = new FizzBuzzApp(
        new String[]{"1", "2", "3", "4", "5", "7", "15", "16", "17", "18", "19", "20", "21"});

    Assert.assertEquals("1 2 alfresco 4 buzz 7 fizzbuzz 16 17 fizz 19 buzz fizz",
        sut.convert());
    Assert
        .assertEquals("alfresco: 1, fizzbuzz: 1, fizz: 2, buzz: 2, number: 7", sut.printMetrics());
  }
}
