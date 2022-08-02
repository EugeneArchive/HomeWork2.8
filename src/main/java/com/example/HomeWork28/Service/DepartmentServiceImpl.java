package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@Service
public abstract class DepartmentServiceImpl implements DepartmentService {

    private EmployeeService employeeService;
    private Employee employee;
   private  Map<String, Employee> EMPLOYEES;


    @Override
    public Optional<Employee> maxSalary(int departmentId) {
        return EMPLOYEES.values().stream()
                .filter(e -> EMPLOYEES.containsValue(departmentId))
               .max(Comparator.comparingDouble(e -> employee.getSalary()))
        ;
      //  return null;
    }

    @Override
    public Optional<Employee> minSalary(int departmentId) {
        return null;
    }

    @Override
    public Optional<Employee> departmentEmployees(int departmentId) {
        return null;
    }

    @Override
    public Employee allEmployees() {
        return null;
    }
}
