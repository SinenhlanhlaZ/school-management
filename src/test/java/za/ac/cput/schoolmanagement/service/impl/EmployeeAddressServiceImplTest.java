package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/*
  EmployeeAddressFactoryTest.java
  Test case for EmployeeAddressFactoryTest
  Author: Ishmail T Mgwena (215088417)
  Date: 16 June 2022
 */
@SpringBootTest
class EmployeeAddressServiceImplTest {

    private final City city = CityFactory.build("675","Cape Town");
    private final Address address = AddressFactory.build("39","Fox Street","7",
            "SeaView",3090,city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("438",address);

    @Autowired
    private IEmployeeAddressService employeeAddressService;

    @Test
    void findAll() {
        List<EmployeeAddress> employeeAddressListList = this.employeeAddressService.findAll();
        assertEquals(0, employeeAddressListList.size());
    }
    @Test
    void save() {
        EmployeeAddress saved = this.employeeAddressService.save(this.employeeAddress);
        assertEquals(this.employeeAddress, saved);
    }
    @Test
    void read() {
        Optional<EmployeeAddress> read = this.employeeAddressService.read(this.employeeAddress.getStaffId());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(this.employeeAddress, read.get())
        );
    }
    @Test
    void delete() {
        this.employeeAddressService.delete(this.employeeAddress);
        List<EmployeeAddress> employeeAddressListList = this.employeeAddressService.findAll();
        assertEquals(0, employeeAddressListList.size());
    }

}