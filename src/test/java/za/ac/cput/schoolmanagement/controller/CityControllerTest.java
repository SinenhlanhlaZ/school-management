package za.ac.cput.schoolmanagement.controller;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerTest {

    Country country = CountryFactory.build("1", "South Africa");

    @LocalServerPort
    private int portNum;

    private City city;
    private String url;

    @Autowired
    private TestRestTemplate restTmplte;

    @Autowired
    private CityController cityCtrl;

    @BeforeEach
    public void setUp() {
        this.city = CityFactory.build("1", "Durban", new Country());
        this.url = "http://localhost:" + this.portNum + "/schoolmanagement/city/";
    }

    @Test
    public void read()
    {
        String strUrl = url + "read/" + this.city.getId();
        ResponseEntity<City> response = this.restTmplte.getForEntity(strUrl, City.class);

        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }

    @Test
    public void save()
    {
        String strUrl = url + "save";
        ResponseEntity<City> response = this.restTmplte.postForEntity(strUrl, this.city, City.class);

        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertNotNull(response.getBody()));
    }


    @Test
    public void delete()
    {
        String strUrl = url + "delete/" + this.city.getId();
        this.restTmplte.delete(strUrl);
    }

    @Test
    public void findAll()
    {
        String strUrl = url + "all";
        ResponseEntity<City[]> response = this.restTmplte.getForEntity(strUrl, City[].class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()), () -> assertTrue(response.getBody().length == 0));
    }

}
