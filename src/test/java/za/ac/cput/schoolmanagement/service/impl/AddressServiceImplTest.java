package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.service.IAddressService;

@SpringBootTest
public class AddressServiceImplTest {

    Address addr = AddressFactory.build("5", "Ninth Avenue", "91", "", 4001, new City());

    @Autowired
    IAddressService addrService;

    @Test
    public void save()
    {

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
