package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Student;

import java.util.List;
/*
    IStudentServices.java
    Interface for Student Service
    Author: Shina Kara 219333181
    Date: 14/06/2022
*/

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();

    void deleteById(String id);
}
