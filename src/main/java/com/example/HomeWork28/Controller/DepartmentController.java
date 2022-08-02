package com.example.HomeWork28.Controller;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;



    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/max-salary")
    public Optional<Employee> maxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.maxSalary(departmentId);
    }
    @GetMapping(path = "/min-salary")
    public Optional<Employee> minSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.minSalary(departmentId);
    }
    @GetMapping(path = "/all")
    public Optional<Employee> departmentEmployees(@RequestParam("departmentId") int departmentId) {
        return departmentService.departmentEmployees(departmentId);
    }
    @GetMapping(path = "/all")
    public Employee allEmployees() {
        return departmentService.allEmployees();
    }
}
