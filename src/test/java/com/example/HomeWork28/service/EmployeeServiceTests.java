package com.example.HomeWork28.service;


import com.example.HomeWork28.Employee;
import com.example.HomeWork28.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.HomeWork28.service.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {


    @Mock
    private ValidatorService validatorService;
    @InjectMocks
    private EmployeeService out;

    @BeforeEach
    public void setOut() {
        Employee employee1 = new Employee(FIRST_NAME, FIRST_SURNAME, FIRST_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee(anyString(), anyString(), anyInt(), anyDouble())).thenReturn(employee1);
        out.addEmployee(FIRST_NAME, FIRST_SURNAME, FIRST_DEPARTMENT, SALARY);
    }

    @Test
    public void shouldCallEmployeeServiceWhenPrintEmployee() {
        List<Employee> actual = out.getAll();
        List<Employee> expected = new ArrayList<>();
        actual.add(employee);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCallEmployeeServiceWhenAddEmployee() {
        Employee employee2 = new Employee("Pavel", "Tichonov", 2, 100_000);
        when(validatorService.validateEmployee(anyString(), anyString(), anyInt(), anyDouble())).thenReturn(employee2);
        Employee actual = out.addEmployee(SECOND_NAME, SECOND_SURNAME, SECOND_DEPARTMENT, SALARY);
        assertEquals(employee2, actual);

    }

    @Test
    public void shouldCallEmployeeServiceWhenFindEmployee() {
        Employee actual = out.findEmployee(FIRST_NAME, FIRST_SURNAME);
        assertEquals(employee, actual);

    }

    @Test
    public void shouldCallEmployeeServiceWhenRemoveEmployee() {
        Employee actual = out.deleteEmployeeFio(FIRST_NAME, FIRST_SURNAME);
        assertEquals(employee, actual);

    }

    @Test
    public void shouldCallThrowExceptionInEmployeeService() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee(FIRST_NAME, FIRST_SURNAME, FIRST_DEPARTMENT, SALARY));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(SECOND_NAME, SECOND_SURNAME));
        assertThrows(DepartmentIllegalNumber.class, () -> out.addEmployee(SECOND_NAME, SECOND_SURNAME, THROW_DEPARTMENT, SALARY));
        assertThrows(EmployeeNotFoundException.class, () -> out.deleteEmployeeFio(SECOND_NAME, SECOND_SURNAME));
    }

    @Test
    public void shouldCallThrowExceptionFullMemory() {
        Employee employee1 = new Employee("First", "First", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("First", "First", SECOND_DEPARTMENT, SALARY)).thenReturn(employee1);
        out.addEmployee("First", "First", SECOND_DEPARTMENT, SALARY);

        Employee employee2 = new Employee("Second", "Second", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Second", "Second", SECOND_DEPARTMENT, SALARY)).thenReturn(employee2);
        out.addEmployee("Second", "Second", SECOND_DEPARTMENT, SALARY);

        Employee employee3 = new Employee("Third", "Third", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Third", "Third", SECOND_DEPARTMENT, SALARY)).thenReturn(employee3);
        out.addEmployee("Third", "Third", SECOND_DEPARTMENT, SALARY);

        Employee employee4 = new Employee("Forth", "Forth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Forth", "Forth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee4);
        out.addEmployee("Forth", "Forth", SECOND_DEPARTMENT, SALARY);

        Employee employee5 = new Employee("Fifth", "Fifth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Fifth", "Fifth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee5);
        out.addEmployee("Fifth", "Fifth", SECOND_DEPARTMENT, SALARY);

        Employee employee6 = new Employee("Sixth", "Sixth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Sixth", "Sixth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee6);
        out.addEmployee("Sixth", "Sixth", SECOND_DEPARTMENT, SALARY);

        Employee employee7 = new Employee("Seventh", "Seventh", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Seventh", "Seventh", SECOND_DEPARTMENT, SALARY)).thenReturn(employee7);
        out.addEmployee("Seventh", "Seventh", SECOND_DEPARTMENT, SALARY);

        Employee employee8 = new Employee("Eighth", "Eighth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Eighth", "Eighth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee8);
        out.addEmployee("Eighth", "Eighth", SECOND_DEPARTMENT, SALARY);

        Employee employee9 = new Employee("Ninth", "Ninth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Ninth", "Ninth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee9);
        out.addEmployee("Ninth", "Ninth", SECOND_DEPARTMENT, SALARY);

        Employee employee10 = new Employee("Tenth", "Tenth", SECOND_DEPARTMENT, SALARY);
        when(validatorService.validateEmployee("Tenth", "Tenth", SECOND_DEPARTMENT, SALARY)).thenReturn(employee10);
        assertThrows(EmployeeStorageIsFullException.class, () -> out.addEmployee("Tenth", "Tenth", SECOND_DEPARTMENT, SALARY));

    }
}



