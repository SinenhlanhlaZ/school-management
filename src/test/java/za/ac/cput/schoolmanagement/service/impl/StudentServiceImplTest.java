package za.ac.cput.schoolmanagement.service.impl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;
import za.ac.cput.schoolmanagement.service.IStudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/*
    StudentServiceImpTest.java
    Test for Student Service
    Author: Shina Kara (219333181)
    Date: 15/06/2022
*/
@SpringBootTest
class StudentServiceImplTest {

    private final Name name = NameFactory.build("Shina", "-", "Kara");
    private final Student student = StudentFactory.build("219333181", "219333181@mycput.ac.za", name);

    @Autowired
    private IStudentService studentService;


    //save student
    @Test
    void save() {
        Student saved = this.studentService.save(this.student);
        assertEquals(this.student, saved);
    }
    //
    @Test
    void read() {

        Optional<Student> read = this.studentService.read(this.student.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student, read.get())
        );
    }
    //finds the saved students
    @Test
    void findAll() {
        List<Student> studentList = this.studentService.findAll();
        assertEquals(0, studentList.size());

    }
    // delete - return nothing
    @Test
    void delete() {
        this.studentService.delete(this.student);
        List<Student> studentList = this.studentService.findAll();
        assertEquals(0, studentList.size());
    }
}