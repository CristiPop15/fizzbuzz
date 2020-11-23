package com.fizzbuzz.test;

import com.fizzbuzz.metric.MetricsMonitoring;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsMonitoringTest {

  @Autowired
  private MetricsMonitoring sut;

  @Test
  public void addAlfrescoTest() {
    sut.addAlfresco();
    Assert.assertEquals("alfresco: 1, fizzbuzz: 0, fizz: 0, buzz: 0, number: 0",
        sut.toString());
  }

  @Test
  public void addFizzbuzzTest() {
    sut.addFizzbuzz();
    Assert.assertEquals("alfresco: 0, fizzbuzz: 1, fizz: 0, buzz: 0, number: 0",
        sut.toString());
  }

  @Test
  public void addFizzTest() {
    sut.addFizz();
    Assert.assertEquals("alfresco: 0, fizzbuzz: 0, fizz: 1, buzz: 0, number: 0",
        sut.toString());
  }

  @Test
  public void addBuzzTest() {
    sut.addBuzz();
    Assert.assertEquals("alfresco: 0, fizzbuzz: 0, fizz: 0, buzz: 1, number: 0",
        sut.toString());
  }

  @Test
  public void addNumberTest() {
    sut.addNumber();
    Assert.assertEquals("alfresco: 0, fizzbuzz: 0, fizz: 0, buzz: 0, number: 1",
        sut.toString());
  }
}
