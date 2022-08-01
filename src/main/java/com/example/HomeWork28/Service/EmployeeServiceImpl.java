package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.EmployeeAlreadyAddedException;
import com.example.HomeWork28.Exception.EmployeeNotFoundException;
import com.example.HomeWork28.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> EMPLOYEES;

    public EmployeeServiceImpl() {
        this.EMPLOYEES = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String name, String surname, int departmentName, double salary) {
        Employee employee = new Employee(surname, name, departmentName, salary);
        if (EMPLOYEES.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных. Добавление невозможно");
        }
        if (EMPLOYEES.size() < LIMIT) {
            EMPLOYEES.put(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("Список сотрудников заполнен. Добавление нового сотрудника невозможно");
    }

    @Override
    public Employee deleteEmployeeFio(String name, String surname) {
        String s = surname + " " + name;
              if (!EMPLOYEES.containsKey(s)) {
            throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
        }
        return EMPLOYEES.remove(s);
    }

    @Override
    public Employee findEmployee(String surname, String name) {
        String s = surname + " " + name;
        if (EMPLOYEES.containsKey(s)) {
            throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
        }
        return EMPLOYEES.get(s);
    }

    @Override
    public Collection<Employee> printEmployee() {
        return Collections.unmodifiableCollection(EMPLOYEES.values());
    }
}
