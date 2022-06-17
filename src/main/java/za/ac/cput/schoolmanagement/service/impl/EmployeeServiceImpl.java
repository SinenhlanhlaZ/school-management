package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.EmployeeRepository;
import za.ac.cput.schoolmanagement.service.IEmployeeService;

import java.util.List;
import java.util.Optional;
/*
    EmployeeServiceImpl.java
    Implementation for EmployeeService
    Author: Fayaad Abrahams (218221630)
    Date: 14/06/2022
*/
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository repository;

    @Autowired public EmployeeServiceImpl(EmployeeRepository repository) {this.repository = repository;}

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Employee> employee = read(id);
        if (employee.isPresent()) delete(employee.get());
    }

    @Override
    public Employee save(Employee employee) { return this.repository.save(employee);}

    @Override
    public Optional<Employee> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

       /* Code a service to get the employee name given an employee email. Check if the email is valid and exists.*/
       @Override
       public Optional<Employee> findByEmail(String email) {
           return this.repository.findByEmail(email);
       }

}
