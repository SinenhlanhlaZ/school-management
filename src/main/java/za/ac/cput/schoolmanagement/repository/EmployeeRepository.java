package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;

import java.util.List;
import java.util.Optional;

/*
    EmployeeRepository.java
    Repository for Employee
    Author: Fayaad Abrahams (218221630)
    Date: 12/06/2022
*/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //Code a service to get the employee name given an employee email. Check if the email is valid and exists.
    Optional<Employee> findByEmail (String email);
}
