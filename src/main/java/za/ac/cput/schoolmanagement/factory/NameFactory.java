package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.StringHelper;

/*
    NameFactory.java
    Factory for Name
    Author: Fayaad Abrahams (218221630)
    Date: 11/06/2022
*/
public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName) {
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.checkStringParam("lastName", lastName);
        middleName = StringHelper.setEmptyIfNull(middleName);
        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }

public class NameFactory {
}
