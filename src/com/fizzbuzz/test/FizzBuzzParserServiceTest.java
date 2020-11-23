package com.fizzbuzz.test;

import com.fizzbuzz.parser.FizzBuzzParserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzParserServiceTest {

  @Autowired
  private FizzBuzzParserService sut;

  @Test
  public void convertTest_pass() {
    Assert.assertEquals("1 2 alfresco 4 buzz",
        sut.convert(new String[]{"1", "2", "3", "4", "5"}));

    Assert.assertEquals("1 2 alfresco 4 buzz 7 fizzbuzz",
        sut.convert(new String[]{"1", "2", "3", "4", "5", "7", "15"}));

    Assert.assertEquals("alfresco buzz fizzbuzz alfresco buzz fizzbuzz fizz alfresco",
        sut.convert(new String[]{"3", "5", "15", "30", "25", "90", "66", "13"}));
  }

  @Test
  public void convertTest_null() {
    Assert.assertEquals("", sut.convert(null));
  }

  @Test(expected = NumberFormatException.class)
  public void convertTest_StringParseError() {
    sut.convert(new String[]{"String"});
  }

  @Test
  public void printMetricsTest() {
    Assert.assertEquals("1 2 alfresco 4 buzz 7 fizzbuzz 16 17 fizz 19 buzz fizz",
        sut.convert(
            new String[]{"1", "2", "3", "4", "5", "7", "15", "16", "17", "18", "19", "20", "21"}));
    Assert
        .assertEquals("alfresco: 1, fizzbuzz: 1, fizz: 2, buzz: 2, number: 7", sut.printMetrics());
  }
}
