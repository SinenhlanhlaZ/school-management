package za.ac.cput.schoolmanagement.factory;
/*
  EmployeeAddressFactoryTest.java
  Entity: EmployeeAddressFactoryTest
  Author: Ishmail T Mgwena (215088417)
  Date: 15 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    public void createEmployeeAddressTest(){
        City city = CityFactory.build("309","Cape Town");
        Address employeeAddress = AddressFactory.build("209","Fox",
                "34","Shelter",1005,city);




    }

}