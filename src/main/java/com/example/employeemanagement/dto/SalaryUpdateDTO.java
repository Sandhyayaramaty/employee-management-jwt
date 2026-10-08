package com.example.employeemanagement.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class SalaryUpdateDTO {

    @NotNull(message = "Salary cannot be null")
    @Digits(integer = 10, fraction = 2)
    @Positive(message = "Salary must be greater than 0")
    private BigDecimal salary;

    public SalaryUpdateDTO() {
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}