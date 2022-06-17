package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> findAll();

    void deleteById(String id);
}
