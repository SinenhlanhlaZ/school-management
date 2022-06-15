package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
    EmployeeServiceImplTest.java
    Test for EmployeeServiceImplTest
    Author: Fayaad Abrahams (218221630)
    Date: 14/06/2022
*/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    private final Name name = NameFactory.build("Fayaad", "middle", "Abrahams");
    private final Employee employee = EmployeeFactory.build("2323123131", "eazypeazy@cput.ac.za", name);

    @Autowired
    private IEmployeeService employeeService;

    @Order(1)
    @Test
    void save() {
        Employee saved = this.employeeService.save(this.employee);
        assertEquals(this.employee, saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Employee> read = this.employeeService.read(this.employee.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employee, read.get())
        );
    }

    @Order(4)
    @Test
    void findAll() {
        List<Employee> employeeList = this.employeeService.findAll();
        assertEquals(0, employeeList.size());
    }

    @Order(3)
    @Test
    void delete() {
        this.employeeService.delete(this.employee);
        List<Employee> employeeList = this.employeeService.findAll();
        assertEquals(0, employeeList.size());

    }
}