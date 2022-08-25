package com.example.HomeWork28;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;



public class Employee {
    @JsonProperty("lastName")
    private String surname;
    @JsonProperty("firstName")
    private String name;

    private final int departmentId;
    private final double salary;

    public Employee(String name, String surname, int departmentId, double salary) {
        //this.name = capitalize(name.toLowerCase());
       // this.surname = capitalize(surname.toLowerCase());
        this.name = name;
        this.surname = surname;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentName() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return name + " " + surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return surname.equals(employee.surname) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

    @Override
    public String toString() {
        return "Employee: " + surname + " " + name + ", departmentId= " + departmentId + ", salary= " + salary;
    }
}
