package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Country;

/*
CountryFactoryTest.java
Country Factory Test
Nonzwakazi Mgxaji 213181584
 */

class CountryFactoryTest {
    @Test
    void buildWithId(){
        Country country = new Country();
        country.setId("29");
        Assertions.assertNotNull(country.getId());
    }
}