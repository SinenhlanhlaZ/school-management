package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    StudentControllerTest.java
    Test for Student Controller
    Author: Shina Kara (219333181)
    Date: 16/06/2022
*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    //Adding name to test
    private final Name name = NameFactory.build("Shina", "-", "Kara");

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl;
    private Student student;

    @BeforeEach
    void setUp() {
        this.student = StudentFactory.build("16", "shinakara@gmail.com", name);
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/student/";
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.postForEntity(url, this.student, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.student.getStudentId();
        System.out.println(url);
        System.out.println("*******");
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }


    @Test
    void delete() {

        String url = baseUrl + "delete/" + this.student.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Student[]> response = this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0));
    }

}