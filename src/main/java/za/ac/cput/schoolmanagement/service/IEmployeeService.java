package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String> {
    List<Employee> findAll();

    void deleteById(String id);

    //Code a service to get the employee name given an employee email. Check if the email is valid and exists.
    /* List<Employee> findByName_FirstName(String email);*/

}
