package za.ac.cput.schoolmanagement.repository;
/*
  EmployeeAddressRepository.java
  Entity: EmployeeAddressRepository
  Author: Ishmail T Mgwena (215088417)
  Date: 14 June 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

}
