package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/*
    Student.java
    Student Domain
    Author: Shina Kara 219333181
    Date: 12/06/2022
*/
@Entity
public class Student implements Serializable {
    @Id
    @NotNull
    private String studentId;
    @NotNull
    private String email;

    @Embedded
    @NotNull
    private Name name;

    protected Student() {
    }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.equals(o)) return true;
        if (o.equals(null) || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }


    public static class Builder {
        private String studentId, email;
        private Name name;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.email = student.email;

            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

}

