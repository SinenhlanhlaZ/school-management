package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerTest {

    private Address addr = AddressFactory.build("5",
            "Ninth Avenue", "91", "Avonmore",
            4001, new City());

    @LocalServerPort
    private int portNum;

    private City city;
    private String url;

    @Autowired
    private CityController cityController;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        this.city = CityFactory.build("1", "Durban", new Country());
        this.url = "http://localhost:" + this.portNum + "/schoolmanagement/employee/";
    }

    @Test
    public void save() {
        String strUrl = url+"save";
        ResponseEntity<City> response = this.restTemplate.postForEntity(strUrl, this.city, City.class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    public void read() {
        String strUrl = url + "read/" + this.city.getId();
        ResponseEntity<City> response = this.restTemplate.getForEntity(strUrl, City.class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody())
        );
    }


    @Test
    public void delete() {
        String strUrl = url + "delete/" + this.city.getId();
        this.restTemplate.delete(strUrl);
    }

    @Test
    public void findAll() {
        String strUrl = url + "all";
        ResponseEntity<City[]> response = this.restTemplate.getForEntity(strUrl, City[].class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertTrue(response.getBody().length == 0));
    }

}
