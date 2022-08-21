package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.InvalidNameException;
import com.example.HomeWork28.Exception.InvalidSurnameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public Employee validateEmployee(String name,
                                      String surname,
                                      int departmentName,
                                      double salary) {
        if (!StringUtils.isAlpha(name)) {
            throw new InvalidNameException();
        }
        if (!StringUtils.isAlpha(surname)) {
            throw new InvalidSurnameException();
        }
        return new Employee(
                StringUtils.capitalize(name.toLowerCase()),
                StringUtils.capitalize(surname.toLowerCase()),
                departmentName,
                salary);
    }
}

