package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String name, String surname, int departmentName, double salary);

    Employee deleteEmployeeFio(String name, String surname);

    Employee findEmployee(String surname, String name);

    Collection<Employee> printEmployee();
}
