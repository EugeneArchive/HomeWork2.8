package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.*;
import org.springframework.stereotype.Service;


import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> EMPLOYEES;

    public EmployeeService() {
        this.EMPLOYEES = new HashMap<>();
    }


    public Employee addEmployee(String name, String surname, int departmentName, double salary) {
        checkEmployee(name, surname);
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
        checkEmployee(name, surname);
        String s = surname + " " + name;
        if (!EMPLOYEES.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
        return EMPLOYEES.remove(s);
    }


    public Employee findEmployee(String name, String surname) {
        checkEmployee(name, surname);
        String s = name + " " + surname;
        if (!EMPLOYEES.containsKey(s)) {
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

    private void checkEmployee(String name, String surname) {
        if (!(isAlpha(name) && isAlpha(surname))) {
            throw new BadRequest();
        }
    }
}
