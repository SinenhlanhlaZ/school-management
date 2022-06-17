package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/*
  EmployeeAddressControllerTest.java
  Implementation of EmployeeAddressControllerTest
  Author: Ishmail T Mgwena (215088417)
  Date: 17 June 2022
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController employeeAddressController;

    @Autowired private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private Address address;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeAddressController);
        this.employeeAddress = EmployeeAddressFactory.build("438",address);
        this.baseUrl = "http://localhost:" + this.port + "school-management/employee-address/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate
                .postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody()));
    }
    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.getForEntity(url,EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Order(3)
    @Test
    void delete() {
            String url = baseUrl + "delete/" + this.employeeAddress.getStaffId();
            this.restTemplate.delete(url);
    }
    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response =
                this.restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0));
    }
}
