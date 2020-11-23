package com.fizzbuzz.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handle(Exception ex,
      HttpServletRequest request, HttpServletResponse response) {
    if (ex instanceof NumberFormatException) {
      return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
