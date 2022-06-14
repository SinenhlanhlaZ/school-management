package za.ac.cput.schoolmanagement.factory;
/*
StudentAddress.java
this is a Factory class for studentAddress
Author: Sinazo Mehlomakhulu(216076498)
Date 13/06/2022
 */
import org.apache.tomcat.jni.Address;

import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.helper.Helper;

public class StudentAddressFactory {
    public static StudentAddress newStudentAddress(String studentId, Address address){
        Helper.checkStringParam("studentId", studentId);
        Helper.isObjectNull(address);

        return new StudentAddress.StudentAddressBuilder().
                setStudentId(studentId).
                setAddress(address).
                build();

    }
}
