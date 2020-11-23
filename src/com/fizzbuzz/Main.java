package com.fizzbuzz;

import com.fizzbuzz.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = AppConfig.class)
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
