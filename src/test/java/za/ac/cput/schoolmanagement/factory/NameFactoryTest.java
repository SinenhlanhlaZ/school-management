package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.schoolmanagement.domain.Name;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    NameFactoryTest.java
    Test Class for NameFactory
    Author: Fayaad Abrahams (218221630)
    Date: 12/06/2022
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameFactoryTest {

    @Order(1)
    @Test
    public void buildWithNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NameFactory
                .build("", "middle", "Abrahams"));
        String message = exception.getMessage();
        System.out.println(message);
    }

    @Order(2)
    @Test
    public void buildWithNullLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NameFactory
                .build("Fayaad", "middle", ""));
        String message = exception.getMessage();
        System.out.println(message);
    }

    @Order(3)
    @Test
    public void buildWithNullMiddleName() {
        Name name = NameFactory.build("Fayaad", "", "Abrahams");
        System.out.println(name);
    }

    @Order(4)
    @Test
    public void buildWithSuccess() {
        Name name = NameFactory.build("Fayaad", "Middle", "Abrahams");
        System.out.println(name);
    }
}