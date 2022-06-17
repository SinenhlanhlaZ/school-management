package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.List;


public interface IStudentAddressService extends IService<StudentAddress, String> {
    void deleteById(String id);
    List<StudentAddress> findAll();
}
