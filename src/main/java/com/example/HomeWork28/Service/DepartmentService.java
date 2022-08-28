package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.DepartmentIllegalNumber;
import com.example.HomeWork28.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    protected DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*public Optional<Employee> maxSalary(int departmentId) {
        Optional<Employee> employee = employeeService.printEmployee().values().stream()
                .filter(e -> e.getDepartmentName() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary));
        return Optional.ofNullable(employee.orElseThrow(() -> new DepartmentIllegalNumber("Неправильный номер отдела")));
    }*/

    public Employee maxSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentName() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(DepartmentIllegalNumber::new);
    }

    public Employee minSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentName() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(DepartmentIllegalNumber::new);
    }

    public List<Employee> departmentEmployees(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentName() == departmentId)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> printDepartmentEmployees() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));

    }
    //    public Optional<Employee> minSalary(int departmentId) {
//        Optional<Employee> employee = employeeService.printEmployee().values().stream()
//                .filter(e -> e.getDepartmentName() == departmentId)
//                .min(Comparator.comparingDouble(Employee::getSalary));
//        return Optional.ofNullable(employee.orElseThrow(() -> new DepartmentIllegalNumber("Неправильный номер отдела")));
//    }

//    public List<Employee> departmentEmployees(int departmentId) {
//        return employeeService.printEmployee().values().stream()
//                .filter(e -> e.getDepartmentName() == departmentId)
//                .collect(Collectors.toList());
//
//    }

//    public Map<Integer, List<Employee>> printAllDepartmentEmployee() {
//        Map<Integer, String> collect = employeeService.printEmployee().values().stream()
//                .collect(Collectors.groupingBy(e -> e.getDepartmentName(),
//                        Collectors.mapping(e -> e.getFullName(),
//                                Collectors.joining(", ", "(", ")"))));
//        return collect;
//    }
}
