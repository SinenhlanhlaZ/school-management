package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp() throws IllegalAccessException {
        Country country = CountryFactory.build("12", "David");
        City city = CityFactory.build("12", "Cape Town", country);
        Address address = AddressFactory.build("2", "river dale", "23", "Pleasant Place", 7780, city);
        this.employeeAddress = EmployeeAddressFactory.build("233234", address);
        this.baseUrl = "Http://localhost:" + this.port + "/schoolmanagement/employee-address";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        ResponseEntity<EmployeeAddress> response = this.restTemplate.getForEntity(url, EmployeeAddress.class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
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
        ResponseEntity<EmployeeAddress[]> response = this.restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertEquals(0, response.getBody().length));

    }
}