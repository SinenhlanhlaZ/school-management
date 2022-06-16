package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.helper.StringHelper;

/*
    EmployeeAddressFactory.java
    Entity: EmployeeAddressFactory
    Author: Ishmail T Mgwena (215088417)
    Date: 14 June 2022
*/
public class EmployeeAddressFactory {

    public static EmployeeAddress build(String staffId, Address address)
        throws IllegalAccessException {
        checkAttributes(staffId, address);
        return new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address).build();
    }
    private static void checkAttributes(String staffId, Address address)
        throws IllegalAccessException {
        StringHelper.checkStringParam("staffId", staffId);
        StringHelper.checkObjectNull("address", address);
    }
}
