package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import java.util.List;
/*
    EmployeeAddress.java
    Implementation of EmployeeAddressController
    Author: Ishmail T Mgwena (215088417)
    Date: 14 June 2022

*/
@RestController
@RequestMapping("schoolmanagement/employee-address")
@Slf4j
public class EmployeeAddressController {
    private final IEmployeeAddressService service;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@RequestBody EmployeeAddress employeeAddress) {
        log.info("Save request: {}", employeeAddress);
        EmployeeAddress save = service.save(employeeAddress);
        return ResponseEntity.ok(save);
    }


    @GetMapping("read/{id}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        EmployeeAddress employeeAddress = this.service.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> findAll() {
        List<EmployeeAddress> employees = this.service.findAll();
        return ResponseEntity.ok(employees);
    }

}
