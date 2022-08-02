package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;

import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> maxSalary(int departmentId);

    Optional<Employee> minSalary(int departmentId);

    Optional<Employee> departmentEmployees(int departmentId);

    Employee allEmployees();
}
