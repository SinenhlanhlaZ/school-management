package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;
/*
    IEmployeeRepository.java
    Repository for Employee
    Author: Fayaad Abrahams (218221630)
    Date: 12/06/2022
*/
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}
