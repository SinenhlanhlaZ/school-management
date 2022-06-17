package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;
import za.ac.cput.schoolmanagement.service.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {

    private final Country country = CountryFactory.build("1001101", "England");
    private final City city = CityFactory.build("129310", "Derry", country);
    private final Address address = AddressFactory.build("9", "Derry Ville", "2", "River Dale rd", 1218, city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("2020", address);

    @Autowired
    private IEmployeeAddressService service;


    EmployeeAddressServiceImplTest() throws IllegalAccessException {
    }

    @Order(1)
    @Test
    void save() {
        EmployeeAddress saved = this.service.save(this.employeeAddress);
        assertEquals(this.employeeAddress, saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<EmployeeAddress> read = this.service.read(this.employeeAddress.getStaffId());
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(this.employeeAddress, read.get()));
    }

    @Order(4)
    @Test
    void findAll() {
        List<EmployeeAddress> employeeAddressList = this.service.findAll();
        assertEquals(0, employeeAddressList.size());
    }

    @Order(3)
    @Test
    void delete() {
        this.service.delete(this.employeeAddress);
        List<EmployeeAddress> employeeAddressList = this.service.findAll();
        assertEquals(0, employeeAddressList.size());
    }
}