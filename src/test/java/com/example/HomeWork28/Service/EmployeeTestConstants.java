package com.example.HomeWork28.Service;


import com.example.HomeWork28.Employee;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Eugene";
    public static final String FIRST_SURNAME = "Serebrov";
    public static final String SECOND_NAME = "Pavel";
    public static final String SECOND_SURNAME = "Tichonov";
    public static final String THIRD_NAME = "Maxim";
    public static final String THIRD_SURNAME = "Petrov";
    public static final int FIRST_DEPARTMENT = 2;
    public static final int SECOND_DEPARTMENT = 1;
    public static final int THROW_DEPARTMENT = 10;
    public static final double SALARY = 100_000;
    public static final Employee employee = new Employee(FIRST_NAME, FIRST_SURNAME, FIRST_DEPARTMENT, SALARY);
}
