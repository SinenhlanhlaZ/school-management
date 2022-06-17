package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class StudentAddress {

    @Id
    @NotNull
    private String studentId;

    @Embedded
    private Address address;

    public StudentAddress() {
    }

    private StudentAddress(Builder stuAddrBuilder) {
        this.studentId = stuAddrBuilder.studentId;
        this.address = stuAddrBuilder.address;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder {
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress stuAdd) {
            this.studentId = stuAdd.studentId;
            this.address = stuAdd.address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }

    }

}
