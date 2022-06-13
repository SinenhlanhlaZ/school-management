package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.StringHelper;
/*
    EmployeeFactory.java
    Factory for Employee
    Author: Fayaad Abrahams (218221630)
    Date: 12/06/2022
*/
public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {
        StringHelper.checkStringParam("staff-id", staffId);
        StringHelper.checkStringParam("email",email);
        StringHelper.checkObjectNull("name", name);
        StringHelper.isEmailValid(email);
        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
}
