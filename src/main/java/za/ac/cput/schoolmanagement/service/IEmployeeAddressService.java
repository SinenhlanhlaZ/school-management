package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import java.util.List;
/*
  IEmployeeAddressService.java
  interface for IEmployeeAddressService
  Author: Ishmail T Mgwena (215088417)
  Date: 15 June 2022
 */


public interface IEmployeeAddressService extends IService<EmployeeAddress, String>{
    List<EmployeeAddress>findAll();

    void deleteById(String id);
}
