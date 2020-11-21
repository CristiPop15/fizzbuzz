package com.fizzbuzz.metric;

public class MetricsMonitoring {

  private int alfresco, fizzbuzz, fizz, buzz, number;

  public void addAlfresco() {
    alfresco++;
  }

  public void addFizzbuzz() {
    fizzbuzz++;
  }

  public void addFizz() {
    fizz++;
  }

  public void addBuzz() {
    buzz++;
  }

  public void addNumber() {
    number++;
  }

  @Override
  public String toString() {
        return "alfresco: " + alfresco +
        ", fizzbuzz: " + fizzbuzz +
        ", fizz: " + fizz +
        ", buzz: " + buzz +
        ", number: " + number;
  }
}
