package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.dto.EmployeeUpdateDTO;
import com.example.employeemanagement.dto.SalaryUpdateDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Tells Spring "This class will handle HTTP/REST requests."
@RequestMapping("/employees")
//So all APIs inside this controller start with this
public class EmployeeController {

    //Con Injection
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Uses HTTP POST
    @PostMapping
    public EmployeeResponseDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    //Uses HTTP GET
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    //takes that id from the URL and puts it into the Java variable id.
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        return employeeService.updateEmployeeById(id, employeeUpdateDTO);
    }

    @PatchMapping("/{id}/salary")
    public EmployeeResponseDTO updateSalary(
            @PathVariable Long id,
            @Valid @RequestBody SalaryUpdateDTO salaryUpdateDTO) {

        return employeeService.updateSalary(id, salaryUpdateDTO);
    }

    @DeleteMapping("/{id}")
    // to delete
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

}
