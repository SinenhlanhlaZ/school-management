package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
    EmployeeFactoryTest.java
    Test Class for EmployeeFactory
    Author: Fayaad Abrahams (218221630)
    Date: 12/06/2022
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    Name name = NameFactory.build(
            "Fayaad",
            "middle",
            "Abrahams"
    );

    @Order(1)
    @Test
    public void buildWithNullID() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeFactory.build("", "fakeemail@mycput.ac.za", name));
        String message = exception.getMessage();
        System.out.println(message);

    }

    @Order(2)
    @Test
    public void buildWithNullEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeFactory.build("David", "233131@", name));
        String message = exception.getMessage();
        System.out.println(message);
    }

    @Order(3)
    @Test
    public void buildWithNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeFactory.build("David", "goodemail@gmail.com", null));
        String message = exception.getMessage();
        System.out.println(message);
    }

    @Order(4)
    @Test
    public void buildWithSuccess() {
        Employee employee = EmployeeFactory.build("2182216390", "myemail@gmail.com", name);
        System.out.println(employee);
        assertNotNull(employee);
    }


}