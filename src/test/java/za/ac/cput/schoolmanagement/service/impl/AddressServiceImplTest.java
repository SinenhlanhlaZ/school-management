package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.factory.NameFactory;

@SpringBootTest
public class AddressServiceImplTest {

    //private final Name name = NameFactory.build("Fayaad", "middle", "Abrahams");
    //private final Employee employee = EmployeeFactory.build("2323123131", "eazypeazy@cput.ac.za", name);

    Address addr = AddressFactory.build("5", "Ninth Avenue", "91", "", 4001, new City());
    City city = CityFactory.build("1", "Durban");
}
