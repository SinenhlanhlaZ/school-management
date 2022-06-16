package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.service.ICityService;

import static org.junit.jupiter.api.Assertions.assertSame;

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

    }

    @Test
    public void delete()
    {

    }

    @Test
    public void readAll()
    {

    }

}
