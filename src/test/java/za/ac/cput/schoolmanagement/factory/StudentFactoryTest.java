package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentFactoryTest {
    Name name = NameFactory.build(
            "Shina",
            "-",
            "Kara"
    );

    @Test
    void buildWorking() {
        Student student = StudentFactory.build("16", "shinakara@gmail.com", name);
        System.out.println(student);
        assertNotNull(student);
    }

    @Test
    void buildNotWorking() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeFactory.build(null, "shinakara16@gmail.com", name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}

