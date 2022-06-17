package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.repository.StudentAddressRepository;
import za.ac.cput.schoolmanagement.service.IStudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements IStudentAddressService {

    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<StudentAddress> studentAddress = read(id);
        if (studentAddress.isPresent()) delete(studentAddress.get());
    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}
