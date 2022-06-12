package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/*
    Employee.java
    Entity for Employee
    Author: Fayaad Abrahams (218221630)
    Date: 11/06/2022
*/
@Entity
public class Employee implements Serializable {
    @Id
    @NotNull
    private String staffId;

    @NotNull
    private String email;

    @Embedded
    private Name name;

    protected Employee() {
    }

    public Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Employee{" + "staffId='" + staffId + '\'' + ", email='" + email + '\'' + ", name=" + name + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId) && email.equals(employee.email) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, email, name);
    }

    public static class Builder {
        private String staffId, email;
        private Name name;

        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder copy(Employee employee) {
            this.staffId = employee.staffId;
            this.email = employee.email;
            this.name = employee.name;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
