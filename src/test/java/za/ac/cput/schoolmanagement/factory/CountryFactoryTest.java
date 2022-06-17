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
    void buildWithValidId() {
        Country country = new Country();
        country.setId("17");

        Assertions.assertNotNull(country.getId());
    }
}
