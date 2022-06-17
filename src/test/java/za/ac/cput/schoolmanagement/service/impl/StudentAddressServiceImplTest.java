package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;
import za.ac.cput.schoolmanagement.service.IStudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

    private final Country country = CountryFactory.build("12", "david");
    private final City city = CityFactory.build("12", "David", country);
    private final Address address = AddressFactory.build("20", "River Dale", "2", "Two", 7780, city);
    private final StudentAddress studentAddress = StudentAddressFactory.build("23233", address);

    @Autowired
    private IStudentAddressService studentAddressService;

    @Order(1)
    @Test
    void save() {
        StudentAddress saved = this.studentAddressService.save(this.studentAddress);
        assertEquals(this.studentAddress, saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<StudentAddress> read = this.studentAddressService.read(this.studentAddress.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<StudentAddress> studentAddressesList = this.studentAddressService.findAll();
        assertEquals(1, studentAddressesList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.studentAddressService.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(0, studentAddressList.size());
    }
}