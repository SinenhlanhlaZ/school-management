package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;
/*
  EmployeeAddressServiceImpl.java
  Implementation for EmployeeAddressServiceImpl
  Author: Ishmail T Mgwena (215088417)
  Date: 14 June 2022
 */

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {

    private final EmployeeAddressRepository repository;

    @Autowired
    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;}
    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();
    }
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<EmployeeAddress> employeeAddress = read(id);
        if(employeeAddress.isPresent()) delete(employeeAddress.get());
    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }
    @Override
    public Optional<EmployeeAddress> read(String id) {
        return this.repository.findById(id);
    }
    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }
}

