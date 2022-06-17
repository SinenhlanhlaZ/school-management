package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, String> {
}
