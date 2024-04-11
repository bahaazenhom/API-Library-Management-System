package org.librarymanagement.service;

import org.librarymanagement.model.Book;
import org.librarymanagement.model.Employee;
import java.util.*;
public interface EmployeeService {
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
    public void updateEmployee(int id,Employee employee);
    public Optional<Employee> searchEmployeeById(int id);
    public List<Employee> getAllEmployees();
}
