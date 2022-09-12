package com.example.HomeWork28.сontroller;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/print")
    public Map<String, Employee> printEmployee() {
        return employeeService.printEmployee();

    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname,
                                @RequestParam("departmentId") int departmentId,
                                @RequestParam ("salary") int salary) {
        return employeeService.addEmployee(name, surname, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                   @RequestParam("lastName") String surname) {
        return employeeService.deleteEmployeeFio(name, surname);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String name,
                                 @RequestParam("lastName") String surname) {
        return employeeService.findEmployee(name, surname);
    }
}
