package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.service.ICountryService;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
CountryServiceImplTest.java
Country Service Test
Nonzwakazi Mgxaji 213181584
 */

@SpringBootTest
public class CountryServiceImplTest {
    Country country = CountryFactory.build("1", "South Africa");

    @Autowired
    ICountryService countryService;

    @Test
    void save(){
        Country countrySaved = this.countryService.save(this.country);
        assertNotNull(countrySaved);
        assertSame(this.country, countrySaved);
    }

    @Test
    void read(){
        Country countrySaved = this.countryService.save(this.country);
        Optional<Country> read = this.countryService.read(countrySaved.getId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(countrySaved, read.get())
        );
    }

    void delete() {
        this.countryService.delete(this.country);
        List<Country> countryList = this.countryService.findAll();
        assertEquals(0, countryList.size());
    }

    @Test
    void findAll(){
        List<Country> countryList = this.countryService.findAll();
            assertEquals(0, countryList.size());
    }
}

