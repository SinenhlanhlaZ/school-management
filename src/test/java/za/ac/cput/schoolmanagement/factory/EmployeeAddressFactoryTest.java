package za.ac.cput.schoolmanagement.factory;
/*
  EmployeeAddressFactoryTest.java
  Entity: EmployeeAddressFactoryTest
  Author: Ishmail T Mgwena (215088417)
  Date: 15 June 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeAddressFactoryTest {

    City city = CityFactory.build("509","Cape Town");
    @Test
    public void buildNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CityFactory.build(null,"Cape Town"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
    @Test
    public void buildEmployeeAddress() {
        Address employeeAddress = AddressFactory.build("57","Fox Street",
                "29","Seaview",2980, city);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);

    }

}
