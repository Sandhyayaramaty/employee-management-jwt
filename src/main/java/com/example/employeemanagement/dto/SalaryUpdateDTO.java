package com.example.employeemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SalaryUpdateDTO {

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be greater than 0")
    private Double salary;

    public SalaryUpdateDTO() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}