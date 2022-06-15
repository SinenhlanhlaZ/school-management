package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.City;

public class CityFactoryTest {

    @Test
    void checkIfIdExists()
    {
        City city = new City();
        city.setId("1");

        Assertions.assertNotNull(city.getId());
    }

}
