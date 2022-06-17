package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.helper.StringHelper;
/*
    EmployeeAddressFactory.java
    Implementation of EmployeeAddressFactory
    Author: Ishmail T Mgwena (215088417)
    Date: 14 June 2022
*/
public class EmployeeAddressFactory  {

    public static EmployeeAddress build(String staffId, Address address) {
        StringHelper.checkStringParam("staffId", staffId);
        StringHelper.checkObjectNull("address", address);
        return new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address).build();
    }
}
