package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;

public interface DepartmentService {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Employee departmentEmployees(int departmentId);

    Employee allEmployees();
}
