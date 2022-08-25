package com.example.HomeWork28.Service;


import com.example.HomeWork28.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static com.example.HomeWork28.Service.EmployeeTestConstants.employee;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {


    @Mock
    private ValidatorService validatorService;
    @InjectMocks
    private EmployeeService out;

    @BeforeEach
    public void setOut() {
        Employee employee1 = new Employee("Eugene", "Serebrov", 2, 100_000);
        when(validatorService.validateEmployee("Eugene", "Serebrov", 2, 100_000)).thenReturn(employee1);
        out.addEmployee("Eugene", "Serebrov", 2, 100_000);
    }

    @Test
    public void shouldCallEmployeeServiceWhenPrintEmployee() {
        List<Employee> expected = out.getAll();
        List<Employee> actual = new ArrayList<>();
        actual.add(employee);
        assertEquals(expected, actual);
    }


    @Test
    public void shouldCallEmployeeServiceWhenAddEmployee() {
        Employee employee1 = new Employee("Eugene", "Serebrov", 2, 100_000);
        when(validatorService.validateEmployee("Eugene", "Serebrov", 2, 100_000)).thenReturn(employee1);
        assertEquals(employee1, out.addEmployee("Eugene", "Serebrov", 2, 100_000));
        assertEquals(employee1, out.findEmployee("Eugene", "Serebrov"));
       assertEquals(employee1, out.deleteEmployeeFio("Eugene", "Serebrov"));


    }

}
