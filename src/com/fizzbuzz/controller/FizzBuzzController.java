package com.fizzbuzz.controller;

import com.fizzbuzz.parser.FizzBuzzParserService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class FizzBuzzController {

  @Autowired
  private FizzBuzzParserService fizzBuzzParserService;

  @PostMapping(value = "/api/fizzbuzz", consumes = {"application/json"})
  @ResponseBody
  public String fizzbuzzConvertor(@RequestBody String[] values) {
    return fizzBuzzParserService.convert(values);
  }
}
