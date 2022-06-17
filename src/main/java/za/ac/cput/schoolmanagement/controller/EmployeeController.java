package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

/*
    EmployeeController.java
    Controller for Employee
    Author: Fayaad Abrahams (218221630)
    Date: 14/06/2022
*/
@RestController
@RequestMapping("schoolmanagement/employee/")
@Slf4j
public class EmployeeController {
    private final IEmployeeService employeeService;

    @Autowired
    EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {
        log.info("Save request: {}", employee);
        Employee save = employeeService.save(employee);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Employee employee = this.employeeService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request: {}", id);
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = this.employeeService.findAll();
        return ResponseEntity.ok(employees);
    }
}
