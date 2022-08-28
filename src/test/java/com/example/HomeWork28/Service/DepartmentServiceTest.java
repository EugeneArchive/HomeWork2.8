package com.example.HomeWork28.Service;

import com.example.HomeWork28.Employee;
import com.example.HomeWork28.Exception.DepartmentIllegalNumber;
import com.example.HomeWork28.Exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.HomeWork28.Service.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private final List<Employee> EMPLOYEES1 = new ArrayList<>();
    private final List<Employee> EMPLOYEES2 = new ArrayList<>();
    private final Map<String, Employee> EMPLOYEES3 = new HashMap<>();

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService out;

    @BeforeEach
    public void setOut() {
        Employee employee1 = new Employee(FIRST_NAME, FIRST_SURNAME, SECOND_DEPARTMENT, 20_000);
        Employee employee2 = new Employee(SECOND_NAME, SECOND_SURNAME, SECOND_DEPARTMENT, 25_000);
        Employee employee3 = new Employee(THIRD_NAME, THIRD_SURNAME, FIRST_DEPARTMENT, 30_000);
        EMPLOYEES1.add(employee1);
        EMPLOYEES1.add(employee2);
        EMPLOYEES1.add(employee3);
        Employee employee4 = new Employee(FIRST_NAME, FIRST_SURNAME, SECOND_DEPARTMENT, 20_000);
        Employee employee5 = new Employee(SECOND_NAME, SECOND_SURNAME, SECOND_DEPARTMENT, 25_000);
        Employee employee6 = new Employee(THIRD_NAME, THIRD_SURNAME, FIRST_DEPARTMENT, 30_000);
        EMPLOYEES2.add(employee4);
        EMPLOYEES2.add(employee5);
        EMPLOYEES2.add(employee6);
        EMPLOYEES3.put(employee1.getFullName(), employee1);
        EMPLOYEES3.put(employee2.getFullName(), employee2);
        EMPLOYEES3.put(employee3.getFullName(), employee3);


    }

    @Test
    void shouldCallEmployWithMaxSalaryInDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES1);

        Employee expected = out.maxSalary(FIRST_DEPARTMENT);

        Employee actual = EMPLOYEES2.stream()
                .filter(employee -> employee.getDepartmentName() == FIRST_DEPARTMENT)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCallEmployWithMinSalaryInDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES1);

        Employee expected = out.minSalary(FIRST_DEPARTMENT);

        Employee actual = EMPLOYEES2.stream()
                .filter(employee -> employee.getDepartmentName() == FIRST_DEPARTMENT)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCallDepartmentServiceWhenPrintAllDepartmentEmployee() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES1);

        Map<Integer, List<Employee>> expected = out.printDepartmentEmployees();

        Map<Integer, List<Employee>> actual = EMPLOYEES3.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCallDepartmentServiceWhenPrintDepartmentEmployee() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES1);

        List<Employee> expected = out.departmentEmployees(SECOND_DEPARTMENT);

        List<Employee> actual = EMPLOYEES2.stream()
                .filter(e -> e.getDepartmentName() == SECOND_DEPARTMENT).toList();

        assertEquals(expected, actual);
    }
    @Test
    public void shouldThrowExceptions() {
        assertThrows(DepartmentIllegalNumber.class, () -> out.minSalary(THROW_DEPARTMENT));
        assertThrows(DepartmentIllegalNumber.class, () -> out.maxSalary(THROW_DEPARTMENT));
    }
}