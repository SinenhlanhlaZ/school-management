package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
/*
    Student.java
    Repository for Student
    Author: Shina Kara 219333181
    Date: 12/06/2022
*/
@Entity
public class Student {

    @Id
    @NotNull
    private String studentId;

    private String email;

    @Embedded
    private Name name;

    public Student() {
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

    public static class StudentId {
        private final String studentId, email;

        public StudentId(String studentId, String email) {
            this.studentId = studentId;
            this.email = email;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentId studentId1 = (StudentId) o;
            return studentId.equals(studentId1.studentId) && email.equals(studentId1.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, email);
        }
    }



    public static class Builder {
        private String studentId, email;
        private Name name;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }
        public Builder name (Name name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
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

