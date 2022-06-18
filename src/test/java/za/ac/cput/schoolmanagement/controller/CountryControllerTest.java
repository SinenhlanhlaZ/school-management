package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import java.util.Arrays;
import java.util.Objects;

/*
CountryControllerTest.java
Country Controller Test
Nonzwakazi Mgxaji 213181584
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {

    @LocalServerPort
    private int port;

    private  String baseUrl;

    private Country country;

    @Autowired
    private CountryController countryController;

    @Autowired
    private TestRestTemplate restTemplate;

    CountryControllerTest() {
    }

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("16", "South Africa");
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/country/";
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.postForEntity(url, this.country, Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.country.getId();
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.getForEntity(url, Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }

    @Test
    void delete() {
        String url = baseUrl +"delete/" + this.country.getId();
        this.restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Country[]> response = this.restTemplate.getForEntity(url, Country[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length));
    }
}
