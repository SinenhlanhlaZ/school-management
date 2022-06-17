package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {
    private final EmployeeAddressRepository repository;

    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<EmployeeAddress> employeeAddress = read(id);
        if (employeeAddress.isPresent()) delete(employeeAddress.get());
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }
}
