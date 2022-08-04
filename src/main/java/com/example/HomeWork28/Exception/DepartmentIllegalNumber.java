package com.example.HomeWork28.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Некоректный номер отдела. Добавление невозможно.")
public class DepartmentIllegalNumber extends RuntimeException{
    public DepartmentIllegalNumber(String message) {
        super(message);
    }
}
