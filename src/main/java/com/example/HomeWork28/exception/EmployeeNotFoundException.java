package com.example.HomeWork28.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Поиск завершен. Данного сотрудника нет в базе данных.")
public class EmployeeNotFoundException extends RuntimeException{
  //  public EmployeeNotFoundException(String message) {
//        super(message);
//    }
}
