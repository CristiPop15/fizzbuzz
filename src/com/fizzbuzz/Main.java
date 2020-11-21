package com.fizzbuzz;

public class Main {

  public static void main(String[] args) {
    FizzBuzzApp app = new FizzBuzzApp(args);

    System.out.println(app.convert());
    System.out.println(app.printMetrics());
  }
}
