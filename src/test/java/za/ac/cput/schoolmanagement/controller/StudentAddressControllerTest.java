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
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private StudentAddress studentAddress;
    private Address address;
    private Country country;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.country = CountryFactory.build("12", "David");
        this.city = CityFactory.build("12", "Cape Town", country);
        this.address = AddressFactory.build("2", "river dale", "23", "Pleasant Place", 7780, city);
        this.studentAddress = StudentAddressFactory.build("233234", address);
        this.baseUrl = "Http://localhost:" + this.port + "/schoolmanagement/student-address";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url, StudentAddress.class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.studentAddress.getStudentId();
        this.restTemplate.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<StudentAddress[]> response = this.restTemplate.getForEntity(url, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertEquals(0, response.getBody().length));

    }

}