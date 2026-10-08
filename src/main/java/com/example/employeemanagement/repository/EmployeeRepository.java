package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
    //Employee is the class and Long is the Data Type of the primary key
    //If we extend Jpa Repository it will give all the CURD operations
}
