package com.example.employeemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
//Create/manage a database table for this class with the following fields.
@Data
// comes from Lombok and automatically generates getters, setters, toString(), etc.
public class Employee {
    @Id
    // Marks this field as the Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Automatically generates a unique ID for each record using the database's identity/auto-increment mechanism.
    private long id;
    @NotBlank(message = "Name of the employee can't be blank")
    private String name;
    private BigDecimal salary;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email formate is wrong")
    private String email;
    @NotBlank(message = "The employee has to belong at least one department")
    private String department;
}