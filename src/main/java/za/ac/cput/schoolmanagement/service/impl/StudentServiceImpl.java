package za.ac.cput.schoolmanagement.service.impl;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import za.ac.cput.schoolmanagement.domain.Student;
 import za.ac.cput.schoolmanagement.repository.StudentRepository;
 import za.ac.cput.schoolmanagement.service.IStudentService;
 import java.util.List;
 import java.util.Optional;
/*
    StudentServiceImpl.java
    Implementation for Student Service
    Author: Shina Kara 219333181
    Date: 14/06/2022
*/

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository repository;

    @Autowired public StudentServiceImpl(StudentRepository repository) {this.repository = repository;}

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Student> student = read(id);
        student.ifPresent(this::delete);
    }

    @Override
    public Student save(Student student) {

        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Student student) {


    }
}
