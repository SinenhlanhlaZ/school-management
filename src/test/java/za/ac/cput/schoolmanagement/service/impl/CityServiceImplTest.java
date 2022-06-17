package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.service.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CityServiceImplTest {

    Country c = new Country();

    City city = CityFactory.build("1", "Durban", new Country());

    @Autowired
    ICityService cityService;

    @Test
    public void save()
    {
        City savedCity = this.cityService.save(this.city);
        assertSame(this.city, savedCity);
    }

    @Test
    public void read()
    {
        Optional<City> read = this.cityService.read(this.city.getId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }

    @Test
    public void delete()
    {
        this.cityService.delete(this.city);
        List<City> listOfCities = this.cityService.findAll();
        assertEquals(0, listOfCities.size());
    }

    @Test
    public void readAll()
    {
        List<City> cityList = this.cityService.findAll();
        assertEquals(0, cityList.size());
    }

}
