package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;

import static org.junit.jupiter.api.Assertions.*;

public class AddressFactoryTest {

    @Test
    public void buildWithoutComplexName()
    {
        Address add = new Address();
        add.setComplexName(null);

        City city = new City();

        System.out.println(AddressFactory.build("5",
                "Ninth Avenue",
                "91",
                null,
                4001, city));
        assertNull(add.getComplexName());
        System.out.println("Successfully built without Complex Name.");
    }

    @Test
    public void checkIfAddressExists()
    {
        Address add = new Address();
        add.setStreetNumber("91");
        add.setStreetName("Ninth Avenue");
        assertSame("91", add.getStreetNumber());
        assertSame("Ninth Avenue", add.getStreetName());
        System.out.println("Address exists");
    }
}
