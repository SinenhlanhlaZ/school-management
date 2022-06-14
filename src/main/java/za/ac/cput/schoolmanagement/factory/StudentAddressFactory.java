package za.ac.cput.schoolmanagement.factory;
/*
StudentAddress.java
this is a Factory class for studentAddress
Author: Sinazo Mehlomakhulu(216076498)
Date 13/06/2022
 */
import org.apache.tomcat.jni.Address;

import za.ac.cput.schoolmanagement.helper.StringHelper;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress newStudentAddress(String studentId, Address address){
        StringHelper.checkStringParam("studentId", studentId);
        StringHelper.isObjectNull(address);

        return new StudentAddress.StudentAddressBuilder().
                setStudentId(studentId).
                setAddress(address).
                build();

    }
}

