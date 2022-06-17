package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.helper.StringHelper;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId, Address address) {
        StringHelper.checkStringParam("StudentId", studentId);
        StringHelper.checkObjectNull("address", address);
        return new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(address)
                .build();
    }
}
