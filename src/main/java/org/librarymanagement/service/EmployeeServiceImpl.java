package org.librarymanagement.service;


import jakarta.transaction.Transactional;
import org.librarymanagement.dao.EmployeeRepository;
import org.librarymanagement.model.Book;
import org.librarymanagement.model.Employee;
import org.librarymanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.delete(employee.get());
    }

    @Override
    @Transactional
    public void updateEmployee(int id, Employee employee) {
        Optional<Employee> updatedEmployee = employeeRepository.findById(id);
        if(!updatedEmployee.isPresent()){
            throw new RuntimeException("Employee not found");
        }
        employee.setId(id);
        employeeRepository.save(employee);
    }
    @Override
    public Optional<Employee> searchEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
