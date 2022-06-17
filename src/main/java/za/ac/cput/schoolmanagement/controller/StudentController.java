package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.service.IStudentService;

import javax.validation.Valid;
import java.util.List;

/*
    StudentController.java
    Student Controller
    Author: Shina Kara (219333181)
    Date: 16/06/2022
*/
@RestController
@RequestMapping("schoolmanagement/student/")
@Slf4j
public class StudentController {
    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) { //Add @NotNull by domain
        log.info("Save request: {}", student); //
        Student save = studentService.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Student student = this.studentService.read(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> student = this.studentService.findAll();
        return ResponseEntity.ok(student);
    }

}
