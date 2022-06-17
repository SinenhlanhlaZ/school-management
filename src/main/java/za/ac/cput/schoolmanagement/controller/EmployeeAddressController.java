package za.ac.cput.schoolmanagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import javax.validation.Valid;
import java.util.List;
/*
  EmployeeAddressController.java
  Implementation of EmployeeAddressController
  Author: Ishmail T Mgwena (215088417)
  Date: 17 June 2022
 */

@RestController
@RequestMapping("school-management/employee-address/")
@Slf4j
public class EmployeeAddressController {

    private final IEmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService employeeAddressService) {
        this.employeeAddressService = employeeAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress) {
        log.info("Save request: {}", employeeAddress);
        EmployeeAddress save = employeeAddressService.save(employeeAddress);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        EmployeeAddress employeeAddress = this.employeeAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> findAll() {
        List<EmployeeAddress> employeeAddresses = this.employeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddresses);
    }

}
