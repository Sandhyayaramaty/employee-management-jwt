package com.example.employeemanagement.service;


import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.dto.EmployeeUpdateDTO;
import com.example.employeemanagement.dto.SalaryUpdateDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//This tells spring "This class contains service/business logic. Create and manage an object of this class for me"
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    //We use constructor injection to inject EmployeeRepository into EmployeeService. The final field stores the injected dependency.

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponseDTO saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        responseDTO.setId(savedEmployee.getId());
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setDepartment(savedEmployee.getDepartment());
        responseDTO.setSalary(savedEmployee.getSalary());

        return responseDTO;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> {
                    EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

                    responseDTO.setId(employee.getId());
                    responseDTO.setName(employee.getName());
                    responseDTO.setEmail(employee.getEmail());
                    responseDTO.setDepartment(employee.getDepartment());
                    responseDTO.setSalary(employee.getSalary());

                    return responseDTO;
                })
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        responseDTO.setEmail(employee.getEmail());
        responseDTO.setDepartment(employee.getDepartment());
        responseDTO.setSalary(employee.getSalary());

        return responseDTO;
    }

    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeUpdateDTO employeeUpdateDTO) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setName(employeeUpdateDTO.getName());
        existingEmployee.setEmail(employeeUpdateDTO.getEmail());
        existingEmployee.setDepartment(employeeUpdateDTO.getDepartment());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(updatedEmployee.getId());
        responseDTO.setName(updatedEmployee.getName());
        responseDTO.setEmail(updatedEmployee.getEmail());
        responseDTO.setDepartment(updatedEmployee.getDepartment());
        responseDTO.setSalary(updatedEmployee.getSalary());

        return responseDTO;
    }

    public EmployeeResponseDTO updateSalary(Long id, SalaryUpdateDTO salaryUpdateDTO) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));

        employee.setSalary(salaryUpdateDTO.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(updatedEmployee.getId());
        responseDTO.setName(updatedEmployee.getName());
        responseDTO.setEmail(updatedEmployee.getEmail());
        responseDTO.setDepartment(updatedEmployee.getDepartment());
        responseDTO.setSalary(updatedEmployee.getSalary());

        return responseDTO;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
