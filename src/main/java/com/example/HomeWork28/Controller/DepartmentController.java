package com.example.HomeWork28.Controller;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.minSalary(departmentId);
    }

//    @GetMapping(path = "/all")
//    public Object departmentEmployees(@RequestParam(name = "departmentId",required=false) Integer departmentId) {
//        if (departmentId == null) {
//            return departmentService.printAllDepartmentEmployee();
//        }
//        return departmentService.departmentEmployees(departmentId);
//    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> printDepartmentEmployees(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.departmentEmployees(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findEmployeeFromDepartment() {
        return departmentService.printDepartmentEmployees();
    }
}
