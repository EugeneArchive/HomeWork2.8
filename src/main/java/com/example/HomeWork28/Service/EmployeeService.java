package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.DepartmentIllegalNumber;
import com.example.HomeWork28.Exception.EmployeeAlreadyAddedException;
import com.example.HomeWork28.Exception.EmployeeNotFoundException;
import com.example.HomeWork28.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> EMPLOYEES;

    public EmployeeService() {
        this.EMPLOYEES = new HashMap<>();
    }


    public Employee addEmployee(String name, String surname, int departmentName, double salary) {
        Employee employee = new Employee(surname, name, departmentName, salary);
        if (EMPLOYEES.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных. Добавление невозможно");
        }
        if (departmentName > 5 && departmentName < 0) {
            throw new DepartmentIllegalNumber("Некоректный номер отдела. Добавление невозможно.");
        }
        if (EMPLOYEES.size() < LIMIT) {
            EMPLOYEES.put(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("Список сотрудников заполнен. Добавление нового сотрудника невозможно");
    }


    public Employee deleteEmployeeFio(String name, String surname) {
        String s = surname + " " + name;
              if (!EMPLOYEES.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
        return EMPLOYEES.remove(s);
    }


    public Employee findEmployee(String surname, String name) {
        String s = surname + " " + name;
        if (EMPLOYEES.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
        return EMPLOYEES.get(s);
    }

    public Map<String, Employee> printEmployee() {
        return EMPLOYEES;
    }
    public List<Employee> getAll() {
        return new ArrayList<>(EMPLOYEES.values());
    }

}
