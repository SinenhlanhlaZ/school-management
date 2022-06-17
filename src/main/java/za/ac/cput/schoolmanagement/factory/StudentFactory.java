package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.helper.StringHelper;

/*
    Student.java
    Repository for Student
    Author: Shina Kara 219333181
    Date: 12/06/2022
*/
public class StudentFactory {
    public static Student build(String studentId, String email, Name name) {
        StringHelper.checkStringParam("studentId", studentId);
        StringHelper.checkStringParam("email", email);
        StringHelper.checkObjectNull("name", name);

        return new Student.Builder().studentId(studentId).email(email).name(name).build();

    }
}
