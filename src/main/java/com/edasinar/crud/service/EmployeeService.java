package com.edasinar.crud.service;


import com.edasinar.crud.model.Employee;
import com.edasinar.crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByCompanyId(Long companyId) {
        List<Employee> currentEmp = getAllEmployees();
        return currentEmp.stream()
                .filter(x -> x.getCompany().getId() == companyId)
                .collect(Collectors.toList());
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee currentEmp = getEmployeeById(id);
        if (currentEmp == null || emp == null) {
            return null;
        }

        if (emp.getName() != null) {
            currentEmp.setName(emp.getName());
        }
        if (emp.getPosition() != null) {
            currentEmp.setPosition(emp.getPosition());
        }
        if (emp.getCompany() != null) {
            currentEmp.setCompany(emp.getCompany());
        }

        return saveEmployee(currentEmp);
    }

    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
