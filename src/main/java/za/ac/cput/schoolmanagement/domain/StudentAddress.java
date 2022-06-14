package za.ac.cput.schoolmanagement.domain;
/*
StudentAddress.java
this is Entity studentAddress
Author: Sinazo Mehlomakhulu(216076498)
Date 13/06/2022
 */

import org.apache.tomcat.jni.Address;
//import za.ac.cput.schoolmanagement.domain.Address;

public class StudentAddress {
    private  String studentId;
    private  Address address;

    private StudentAddress(StudentAddressBuilder studentAddressBuilder) {
        this.studentId = studentAddressBuilder.studentId;
        this.address = studentAddressBuilder.address;
    }

    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class StudentAddressBuilder{
        private String studentId;
        private Address address;

        public StudentAddressBuilder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddressBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public StudentAddressBuilder copy(StudentAddress employeeAddress){
            this.studentId = employeeAddress.studentId;
            this.address = employeeAddress.address;
            return this;
        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }
}
