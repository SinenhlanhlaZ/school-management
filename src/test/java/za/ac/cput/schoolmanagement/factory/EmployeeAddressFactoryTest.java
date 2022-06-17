package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressFactoryTest {
    Country country = CountryFactory.build("232","USA");
    City city = CityFactory.build("323","Nevada",country);
    Address address = AddressFactory.build(
            "18",
            "River dale",
            "12",
            "Pleasant Place",
            7960,
            city);

    @Order(1)
    @Test
    public void buildWithNullAddress(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> EmployeeAddressFactory.build("233",null));
        String message = exception.getMessage();
    }

    @Order(2)
    @Test
    public void buildWithNullId(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeAddressFactory.build("",address));
        String message = exception.getMessage();
        System.out.println(message);
    }

    @Order(3)
    @Test
    public void buildWithSucess(){
        try {
            EmployeeAddress employeeAddress = EmployeeAddressFactory.build("232",address);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
/*        assertNotNull(employeeAdress);*/
    }

}