package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Student;

/*
    Student.java
    Repository for Student
    Author: Shina Kara 219333181
    Date: 12/06/2022
*/
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
